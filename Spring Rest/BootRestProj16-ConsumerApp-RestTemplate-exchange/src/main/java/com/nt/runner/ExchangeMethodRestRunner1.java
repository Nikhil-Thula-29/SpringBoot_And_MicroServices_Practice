package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ExchangeMethodRestRunner1 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;	//check main method
	
	@Override
	public void run(String... args) throws Exception {
		//prepare the service url	
		String serviceUrl="http://localhost:8081/BootRestProj14-API-ProviderApp/wish-api/wish";
		//invoke the exchane method
		ResponseEntity<String> response=template.exchange(serviceUrl, HttpMethod.GET, null, String.class);
		//display result info
		System.out.println("result/output is:: "+response.getBody());
		System.out.println("response status code "+response.getStatusCodeValue());
		System.out.println("response status code "+response.getStatusCode());
		
	}

}
