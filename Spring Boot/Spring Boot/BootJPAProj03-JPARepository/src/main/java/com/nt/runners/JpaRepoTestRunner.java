package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerManagementService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner{

	@Autowired
	private ICustomerManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		//deleteByIdInBatch
		/*try {
			String msg=serv.deleteCustomerByIds(Arrays.asList(11,null));  //no error
			//String msg=serv.deleteCustomerByIds(List.of(11,12));       //correct
			//String msg=serv.deleteCustomerByIds(List.of(11,null));   //error due to List.of(11,null) null can be passed in List.of(),but we can give it as Arrays.asList(11,null) then no error.
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//getReferenceById
		/*try {
			Customer cust=serv.getCustomerById(16);
			System.out.println(cust==null?"Customer not found":cust);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//findAll by Example 
		/*try {
			Customer cust=new Customer();
			cust.setCaddrs("vizag");
			cust.setCname("ramesh");
			List<Customer> list=serv.showCustomerByExampleData(cust, true, "billamt","cname");
			list.forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//saveAllAndFlush
		try {
			Customer cust1=new Customer("vamshi","hyd",80000.0f);
			Customer cust2=new Customer("Jagdessh","kodada",89000.0f);
			Customer cust3=new Customer("Raju","nirmal",698122.0f);
			List<Customer> list=List.of(cust1,cust2,cust3);
			String msg=serv.groupRegistrations(list);
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
