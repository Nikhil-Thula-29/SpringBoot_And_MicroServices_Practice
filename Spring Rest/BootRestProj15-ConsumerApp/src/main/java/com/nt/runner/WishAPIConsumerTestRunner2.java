package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.nt.model.Actor;


//@Component
public class WishAPIConsumerTestRunner2 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//create RestTemplate class obj
		RestTemplate template=new RestTemplate();
		//prepare the base url
		String baseUrl="http://localhost:8081/BootRestProj14-API-ProviderApp/wish-api/register";
		//prepare the json body
		String json_body="{\"aid\":1005,\"aname\":\"nikhil\",\"addrs\":\"hyd\",\"income\":75692}";
		//prepare header
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON); //same like accept:application/json
		//prepare the request object
		HttpEntity<String> request=new HttpEntity<String>(json_body,headers);	
		//invoke the API method
		ResponseEntity<String> response=template.postForEntity(baseUrl,request,String.class);
		//show the results
		System.out.println("output is :: "+response.getBody());
		System.out.println("status code:: "+response.getStatusCodeValue());
		System.out.println("status code:: "+response.getStatusCode());
		
		System.out.println("==========");
		String result=template.postForObject(baseUrl, request, String.class);
		System.out.println("output is:; "+result);
	}

}
