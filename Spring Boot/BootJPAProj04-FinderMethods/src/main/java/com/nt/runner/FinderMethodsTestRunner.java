package com.nt.runner;

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
		//invoke the runner methods
		repo.findByCnameEquals("Kiran").forEach(System.out::println);
		
		System.out.println("===============");		
		repo.findByCnameIs("vivek").forEach(System.out::println);
		
		System.out.println("===============");		
		repo.findByCnameIs("vamshi").forEach(System.out::println);
		
		System.out.println("===============");
		repo.getByCname("ramesh").forEach(System.out::println);
		
		System.out.println("===============");
		repo.readByCname("Jagdessh").forEach(System.out::println);
		
		System.out.println("===============");
		repo.findByBillamtBetween(60000f, 90000f).forEach(System.out::println);
		
		System.out.println("===============");
		repo.findByCnameStartsWith("r").forEach(System.out::println);
		
		System.out.println("===============");
		repo.findByCnameEndsWith("h").forEach(System.out::println);
		
		System.out.println("===============");
		repo.findByCnameContaining("ve").forEach(System.out::println);
		
		
		System.out.println("===============");
		repo.findByCnameContainingIgnoreCase("jag").forEach(System.out::println);
		
		
		System.out.println("===============");
		repo.findByCnameLikeIgnoreCase("r%").forEach(System.out::println);
		
		System.out.println("===============");
		repo.findByBillamtGreaterThanEqualAndBillamtLessThanEqual(1000f, 100000f).forEach(System.out::println);
		
		System.out.println("===============");
		repo.findByCaddrsInIgnoreCaseOrCnameContainingIgnoreCase(List.of("hyd","vizag"), "j").forEach(System.out::println);
		
	}
	
	

}
