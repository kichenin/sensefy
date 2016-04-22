package com.zaizi.sensefy.dataprocessing.mico.dbpedia;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

public class DbpediaQueryClient {
	
	private static final String DBPEDIA_ENDPOINT = "http://dbpedia.org/sparql";
	
	private String entityQueryString = "PREFIX dbpedia: <http://dbpedia.org/resource/> "
			+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			+ "PREFIX foaf: <http://xmlns.com/foaf/0.1/>"
			+ "PREFIX geo: <http://www.w3.org/2003/01/geo/wgs84_pos#>"
			+ "SELECT  ?label ?depiction ?comment (GROUP_CONCAT (?type; SEPARATOR = \",\") AS ?typeList) "
			+ "(GROUP_CONCAT (?seeAlso; SEPARATOR = \",\") AS ?seeList) ?lat ?long "
			+ "WHERE "
			+ "{ <%1$s> rdfs:label ?label;"
			+ "rdf:type ?type;"
			+ "OPTIONAL{ <%1$s> rdfs:comment ?comment }"
			+ "OPTIONAL{ <%1$s> foaf:depiction ?depiction }"
			+ "OPTIONAL{ <%1$s> rdfs:seeAlso ?seeAlso }"
			+ "OPTIONAL{ <%1$s> geo:lat ?lat;"
			+ " geo:long ?long}"
			+ "FILTER(lang(?label) = 'en')"
			+ "FILTER(lang(?comment) = 'en')"
			+ "}"
			+ "GROUP BY ?label ?comment ?depiction ?lat ?long";
	
	
	public ResultSet getEntityResults(String id){
		String queryString = buildQueryString(id);
		Query query = QueryFactory.create(queryString);
		QueryEngineHTTP qexec = QueryExecutionFactory.createServiceRequest(DBPEDIA_ENDPOINT, query);
		return qexec.execSelect();
	}
	
	private String buildQueryString(String id){
		return String.format(entityQueryString, id);
	}

}
