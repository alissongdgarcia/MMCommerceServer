package com.socoletas.mmcommerce.server;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;


public class MainTest {
	public static void main(String[] args) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8080/signup";
		JSONObject jSONObject = new JSONObject();
		jSONObject.put("username", "xxxx");
		jSONObject.put("password", "ttttt");
		String requestJson = "{\"username\":\"abc\", \"password\":\"xyz\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(jSONObject.toString(),headers);
		String answer = restTemplate.postForObject(url, entity, String.class);
		System.out.println(answer);
	}
}
