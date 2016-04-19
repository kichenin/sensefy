package com.zaizi.sensefy.dataprocessing.mico.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.CursorMarkParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.zaizi.mico.client.QueryClient;
import org.zaizi.mico.client.exception.MicoClientException;
import org.zaizi.mico.client.model.text.LinkedEntity;

import com.zaizi.sensefy.dataprocessing.search.service.SolrSearchService;

public class MicoIndexUpdater {

	private static final Logger LOG = Logger.getLogger(MicoIndexUpdater.class);

	private static final String CHECK_UPDATED_QUERY = "is_processed_mico:false";

	@Autowired
	private SolrSearchService solrSearchService;
	
	@Autowired
	private QueryClient queryClient;

	public void updateSolrIndex() {
		LOG.info("Running................................");
		SolrClient primaryIndexClient = solrSearchService.getPrimaryIndex();
		SolrClient entityIndexClient = solrSearchService.getEntityCore();
		SolrQuery solrQuery = new SolrQuery(CHECK_UPDATED_QUERY);
		List<MicoItem> micoItems = queryDocuments(primaryIndexClient, solrQuery);
		for (MicoItem micoItem : micoItems) {
			addNamedEntities(micoItem);
		}
	}
	
	private List<SolrInputDocument> addNamedEntities(MicoItem micoItem){
		List<SolrInputDocument> entityDocs = new ArrayList<>();
		try {
			List<LinkedEntity> entities = queryClient.getLinkedEntities(micoItem.getMicoUri());
			for (LinkedEntity linkedEntity : entities) {
				System.out.println(linkedEntity.getEntityMention());
			}
		} catch (MicoClientException e) {
			LOG.error("Error in quering mico platform", e);
		}
		return entityDocs;
	}

	public List<MicoItem> queryDocuments(SolrClient client, SolrQuery solrQuery) {
		List<MicoItem> micoItems = new ArrayList<>();
		solrQuery.setSort(SortClause.asc("id"));
		solrQuery.set("fl", "id,mico_uri,mimetype");
		String cursorMark = CursorMarkParams.CURSOR_MARK_START;
		try {
			boolean done = false;
			while (!done) {
				solrQuery.set(CursorMarkParams.CURSOR_MARK_PARAM, cursorMark);
				QueryResponse response = client.query(solrQuery);
				String nextCursorMark = response.getNextCursorMark();
				List<SolrDocument> hits = response.getResults();
				for (SolrDocument solrDocument : hits) {
					String id = (String) solrDocument.getFieldValue("id");
					String micoUri = (String) solrDocument.getFieldValue("mico_uri");
					String mimetype = (String) solrDocument.getFieldValue("mimetype");
					String[] types = mimetype.split("/");
					String baseType = types[0];
					MicoItem micoItem = new MicoItem();
					micoItem.setSolrId(id);
					micoItem.setMicoUri(micoUri);
					if(baseType.equals("image")){
						micoItem.setContentType(ContentType.IMAGE);
					}else if (baseType.equals("video")) {
						micoItem.setContentType(ContentType.VIDEO);
					}
					else{
						micoItem.setContentType(ContentType.TEXT);
					}
					micoItems.add(micoItem);
				}
				if (cursorMark.equals(nextCursorMark)) {
					done = true;
				}
				cursorMark = nextCursorMark;
			}
		} catch (SolrServerException e) {
			LOG.error("Error occured in quering Solr", e);
		} catch (IOException e) {
			LOG.error("Error occured in quering Solr", e);
		}

		return micoItems;
	}

}
