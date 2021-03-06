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
package org.zaizi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import org.zaizi.sensefy.ui.SensefySearchUiApplication;

/**
 * 
 * @author mfahiz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SensefySearchUiApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class SensefySearchUiApplicationTests {

	@Value("${local.server.port}")
	private int port;

	@Value("${spring.oauth2.client.userAuthorizationUri}")
	private String authorizeUri;

	private RestTemplate template = new TestRestTemplate();

	@Test
	public void contextLoads() {
	}

	@Test
	public void homePageLoads() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/", String.class);
		assertEquals(HttpStatus.FOUND, response.getStatusCode());
	}

	@Test
	public void userEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/user", String.class);
		assertEquals(HttpStatus.FOUND, response.getStatusCode());
	}

	@Test
	public void resourceEndpointProtected() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/resource", String.class);
		assertEquals(HttpStatus.FOUND, response.getStatusCode());
	}

	@Test
	public void loginRedirects() {
		ResponseEntity<String> response = template.getForEntity("http://localhost:"
				+ port + "/login", String.class);
		assertEquals(HttpStatus.FOUND, response.getStatusCode());
		String location = response.getHeaders().getFirst("Location");
		assertTrue("Wrong location: " + location , location.startsWith(authorizeUri));
	}
	
	
	
}
