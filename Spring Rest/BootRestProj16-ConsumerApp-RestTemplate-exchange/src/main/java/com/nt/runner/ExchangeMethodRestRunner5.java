package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Actor;


@Component
public class ExchangeMethodRestRunner5 implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;	//check main method

	@Override
	public void run(String... args) throws Exception {
		//prepare the base url
		String serviceUrl="http://localhost:8081/BootRestProj14-API-ProviderApp/wish-api/reportAll";
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);	
		//show the results
		System.out.println("output is :: "+response.getBody());
		System.out.println("status code:: "+response.getStatusCodeValue());
		System.out.println("status code:: "+response.getStatusCode());
		
		
		System.out.println("=========");
		//convert List/array of json docs to List<Actor> object
		ObjectMapper mapper=new ObjectMapper();
		List<Actor> list=mapper.readValue(response.getBody(), new TypeReference<List<Actor>>(){});	//while passing list 
		list.forEach(System.out::println);
	}

}
