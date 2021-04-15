package com.redhat.optaplannersbs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OptaPlannerSpringBootStarterApplicationTests {

	@Test
	void contextLoads() {
		OptaPlannerSpringBootStarterApplication.main(new String[] {});
	}
	
	@Test
  	public void test200ValidPostRequest() throws URISyntaxException, IOException {
	    final String baseUrl = "http://localhost:"+randomServerPort+"/cloud-balancing/solve";
	    URI uri = new URI(baseUrl);

	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    String requestJson = new String(Files.readAllBytes(Paths.get("src/test/resources/testdata.txt")), StandardCharsets.UTF_8);
		
	    HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, entity, String.class);

	    assertEquals(200, result.getStatusCodeValue());
  	}

	  @Test
	  public void testScore() throws URISyntaxException, IOException {
	    final String baseUrl = "http://localhost:"+randomServerPort+"/cloud-balancing/solve";
	    URI uri = new URI(baseUrl);

	    RestTemplate restTemplate = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    String requestJson = new String(Files.readAllBytes(Paths.get("src/test/resources/testdata.txt")), StandardCharsets.UTF_8);

	    HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
	    ResponseEntity<String> result = restTemplate.postForEntity(uri, entity, String.class);

	    assertEquals(true, result.getBody().contains("0hard/-7410soft"));
	  }

}
