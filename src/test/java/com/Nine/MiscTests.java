package com.Nine;

import static org.junit.Assert.assertEquals;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.Nine.Const.file;;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NineApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MiscTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();	
	//headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

	@Test
	public void testRetrieve() throws JSONException {
		
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

		HttpEntity<String> entity = new HttpEntity<String>(file, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/"),
				HttpMethod.POST, entity, String.class);

		String expected = "{\"response\":[{\"image\":\"http://mybeautifulcatchupservice.com/img/shows/16KidsandCounting1280.jpg\",\"slug\":\"show/16kidsandcounting\",\"title\":\"16 Kids and Counting\"}]}";
		assertEquals(expected, response.getBody());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
