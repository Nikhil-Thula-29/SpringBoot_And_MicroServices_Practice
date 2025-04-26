package com.nt.test;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.controller.CustomerOperationController;
import com.nt.model.Customer;

public class RealtimeDITest {
	

	public static void main(String[] args) {
		
		//Note:: Run only the main method not the application...		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Customer name:: ");
		String name=sc.nextLine();
		System.out.println("Enter Customer Address:: ");
		String add=sc.nextLine();
		System.out.println("Enter Customer Bill Amount:: ");
		double billamount=sc.nextDouble();
		System.out.println("Enter discount percentage:: ");
		double dis=sc.nextDouble();
		
		Customer cust=new Customer();
		cust.setCname(name);
		cust.setCadd(add);
		cust.setBillAmount(billamount);
		cust.setDiscount(dis);
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		CustomerOperationController custop=ctx.getBean("custController",CustomerOperationController.class);
		try {
			String result=custop.processCustomer(cust);
			System.out.println(result);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
