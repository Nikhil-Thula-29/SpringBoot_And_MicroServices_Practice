package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner{

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		repo.findByBillamtBetween(1000f,100000f).forEach(view->{
			System.out.println(view.getClass()+"-------"+Arrays.toString(view.getClass().getInterfaces()));
			System.out.println(view.getCno()+" "+view.getCname());
		});
	}
	
	

}
