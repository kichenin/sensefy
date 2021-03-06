/**
 * (C) Copyright 2015 Zaizi Limited (http://www.zaizi.com).
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 3.0 which accompanies this distribution, and is available at 
 * http://www.gnu.org/licenses/lgpl-3.0.en.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 **/
package org.zaizi.sensefy.api.dto.faceting.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

/**
 * This class manages the Facet Configuration loading. It takes the config from
 * an environment variable set , if not it will take the default one
 * 
 * @author Alessandro Benedetti 22/10/2014 search-api
 * @since 1.4
 */
@Service
public class FacetConfigurer {

	public static final String CONFIG_DIR_VAR = "sensefy.conf.dir";

	public static final String FACET_CONFIGURATION_XML = "/FacetConfiguration.xml";

	private FacetConfigurationList facetConfiguration;

	public FacetConfigurer() throws JAXBException, FileNotFoundException {
		String configPath = System.getProperty(CONFIG_DIR_VAR);
		File facetConfigFile;
		InputStream is = null;
		if (configPath != null) { // load from the environment variable
			facetConfigFile = new File(configPath + FACET_CONFIGURATION_XML);
			if (facetConfigFile.exists())
				is = new FileInputStream(facetConfigFile);

		}
		if (is == null) {
			is = this.getClass().getResourceAsStream("/config/FacetConfiguration.xml"); // takes
																						// the
																						// default
																						// one
		}

		JAXBContext jc = JAXBContext.newInstance(FacetConfigurationList.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		facetConfiguration = (FacetConfigurationList) unmarshaller.unmarshal(is);
		facetConfiguration.initMap();

	}

	public FacetConfigurationList getFacetConfiguration() {
		return facetConfiguration;
	}

	public void setFacetConfiguration(FacetConfigurationList facetConfiguration) {
		this.facetConfiguration = facetConfiguration;
	}

}
