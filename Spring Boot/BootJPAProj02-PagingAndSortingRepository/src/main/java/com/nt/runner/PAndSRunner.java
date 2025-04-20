package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerManagementService;

@Component
public class PAndSRunner implements CommandLineRunner{

	@Autowired
	private ICustomerManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		
		//true->ascending;false->descending
		//sorting
		//forEach(System.out::println) it is method reference
		//serv.getAllCustomers(false, "billamt").forEach(System.out::println);
		
		
		//Pagination
		/*Page<Customer> page=serv.getCustomerByPageNo(0, 3);
		System.out.println("requeste page records are:: ");
		page.getContent().forEach(System.out::println);	//main to write
		System.out.println("total pages count:: "+page.getTotalPages());
		System.out.println("current page no:: "+page.getNumber());
		System.out.println("total no.of records:: "+page.getTotalElements());
		System.out.println("records in the request page :: "+page.getNumberOfElements());
		System.out.println("Is the request page is first page:: "+page.isFirst());
		System.out.println("Is the request page is last page:: "+page.isLast());*/
		
		//sorting and pagination
		/*Page<Customer> page=serv.getSortedCustomerPageNo(0,2,true,"billamt","caddrs");
		page.getContent().forEach(System.out::println);*/
		
		//showing page by page
		serv.showCustomersPageByPage(2);
		
	}

}
