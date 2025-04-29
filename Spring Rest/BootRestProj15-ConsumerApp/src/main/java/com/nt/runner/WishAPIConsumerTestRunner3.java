package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.model.Actor;


@Component
public class WishAPIConsumerTestRunner3 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class obj
		RestTemplate template=new RestTemplate();
		//prepare the base url
		String baseUrl="http://localhost:8081/BootRestProj14-API-ProviderApp/wish-api/report";
		
		//invoke API operations
		ResponseEntity<String> response=template.getForEntity(baseUrl, String.class);
		
		//show the results
		System.out.println("output is :: "+response.getBody());
		System.out.println("status code:: "+response.getStatusCodeValue());
		System.out.println("status code:: "+response.getStatusCode());
		
		System.out.println("==========");
		String result=template.getForObject(baseUrl,String.class);
		System.out.println("output is:; "+result);
	}

}
