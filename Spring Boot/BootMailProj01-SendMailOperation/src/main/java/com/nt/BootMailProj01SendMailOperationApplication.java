package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IPurchaseOrder;

@SpringBootApplication
public class BootMailProj01SendMailOperationApplication {

	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootMailProj01SendMailOperationApplication.class, args);
		//get service class obj ref
		IPurchaseOrder service=ctx.getBean("purchaseService",IPurchaseOrder.class);
		try {
			String resmsg=service.shopping(new String[] {"shirt","trouser","watch"}, new float[] {2000.0f,3000.0f,5000.0f},
														new String[] {"nikhil.thula29@gmail.com","nthula.112@gmail.com"});

			System.out.println(resmsg);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
