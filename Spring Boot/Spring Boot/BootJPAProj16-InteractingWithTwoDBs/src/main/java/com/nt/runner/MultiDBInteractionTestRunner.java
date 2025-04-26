package com.nt.runner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.service.IProductManagementService;

@Component
public class MultiDBInteractionTestRunner implements CommandLineRunner {

	@Autowired
	private IProductManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		
		//save products
		/*Product prod1=new Product("table",90000.0,10.0,true,LocalDateTime.of(2090, 10, 20, 12, 11, 33));	//rem double .0
		Product prod2=new Product("chair",9000.0,10.0,true,LocalDateTime.of(2090, 10, 20, 12, 11, 33));
		List<Product> prodlist=new ArrayList<Product>();
		prodlist.add(prod1);
		prodlist.add(prod2);
		
		serv.registerProducts(prodlist);*/
		
		System.out.println("=================");
		//save offers
		/*Offers off1=new Offers("MonsoonOffer",40.0f,LocalDateTime.now(),LocalDateTime.of(2025, 10, 20, 12, 11, 33));	
		Offers off2=new Offers("GreatIndianSale",50.0f,LocalDateTime.now(),LocalDateTime.of(2025, 10, 20, 12, 11, 33));	
		List<Offers> offlist=new ArrayList<Offers>();
		offlist.add(off1);
		offlist.add(off2);
		
		serv.registerOffers(offlist);*/
		
		serv.showAllProducts().forEach(System.out::println);
		System.out.println("=============");
		serv.showAllOffers().forEach(System.out::println);
	}

}
