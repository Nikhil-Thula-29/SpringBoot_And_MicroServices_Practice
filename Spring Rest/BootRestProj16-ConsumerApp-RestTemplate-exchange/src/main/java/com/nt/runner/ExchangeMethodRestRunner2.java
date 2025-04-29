package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


//@Component
public class ExchangeMethodRestRunner2 implements CommandLineRunner {
	
	@Autowired
	private RestTemplate template;	//check main method

	@Override
	public void run(String... args) throws Exception {
		//prepare the base url
		String serviceUrl="http://localhost:8081/BootRestProj14-API-ProviderApp/wish-api/wish1/{id}/{name}";
		//invoke the API Service/operation
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class, 452,"Suresh");	//3rd arg is for passing request->body+header which will be in post not for get and last is varargs
		
		//show the results
		System.out.println("output is :: "+response.getBody());
		System.out.println("status code:: "+response.getStatusCodeValue());
		System.out.println("status code:: "+response.getStatusCode());
		
	}

}
