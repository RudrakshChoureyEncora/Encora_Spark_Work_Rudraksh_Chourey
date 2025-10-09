package com.UnitTestingMockito.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {

	private final RestTemplate restTemplate;
	

	public JokeService(RestTemplate restTemplate) {
		// TODO Auto-generated constructor stub
		this.restTemplate=restTemplate;
	}
	
	public String getJoke() {
		String resp= restTemplate.getForObject("https://api.chucknorris.io/jokes/random", String.class);
		return resp;
	}
}
