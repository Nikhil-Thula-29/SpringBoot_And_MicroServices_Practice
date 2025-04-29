package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;


//@Component
public class ExchangeMethodRestRunner4 implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;	//check main method

	@Override
	public void run(String... args) throws Exception {
		//prepare the base url
		String serviceUrl="http://localhost:8081/BootRestProj14-API-ProviderApp/wish-api/report";
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);	
		//show the results
		System.out.println("output is :: "+response.getBody());
		System.out.println("status code:: "+response.getStatusCodeValue());
		System.out.println("status code:: "+response.getStatusCode());
		
		
		System.out.println("=========");
		//convert JSON text to model class object using json api
		ObjectMapper mapper=new ObjectMapper();
		Actor actor=mapper.readValue(response.getBody(),Actor.class);	//Deserialization json to object
		System.out.println("Actor Object:: "+actor);
	}

}
