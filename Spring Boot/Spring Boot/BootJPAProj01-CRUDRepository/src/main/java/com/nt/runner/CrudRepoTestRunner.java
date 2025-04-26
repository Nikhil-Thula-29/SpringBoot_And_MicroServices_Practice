package com.nt.runner;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerManagementService;


@Component	//imp
public class CrudRepoTestRunner implements CommandLineRunner{

	@Autowired
	private ICustomerManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		//for save method 
		/*Customer cust=new Customer();
		cust.setCname("Suresh");
		cust.setCaddrs("Vizag");
		cust.setBillamt(630000.00f);
		String resultmsg=serv.registerCustomer(cust);
		System.out.println(resultmsg);*/
		
		//for save all
		/*try {
			List<Customer> list=List.of(new Customer("vivek","gujarat",60000f),
					new Customer("Kiran","Newzland",7546546f),
					new Customer("Vakul","America",360000f));
			String resultmsg=serv.registerCustomerGroup(list);
			System.out.println(resultmsg);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//for existsById
		/*try {
			boolean flag=serv.isCustomerAvailable(100);
			if(flag) {
				System.out.println("Customer available");
			}else {
				System.out.println("Customer not available");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//for count
		/*try {
			System.out.println("Customers count is:: "+serv.getCustomerCount());
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//for findAll
		/*try {
			Iterable<Customer> it=serv.getAllCustomers();
			it.forEach(val->{
				System.out.println(val);
			});
			System.out.println("========or===========");
			Iterator<Customer> li=it.iterator();
			while(li.hasNext()) {
				System.out.println(li.next());
			}
			System.out.println("========or===========");
			for(Customer cust:it) {
				System.out.println(cust);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//for findAllById
		/*try {
			List<Integer> li=List.of(1,2,3,5,36,58,46);
			Iterable<Customer> it=serv.getCustomersByIds(li);
			it.forEach(val->{
				System.out.println(val);
			});
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//for findById
		/*try {
			System.out.println(serv.showCustomerById(1));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(serv.findCustomerById(2));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(serv.fetchCustomerById(4));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//update 2 types direct save and modify by id.
	    //1. modiy and save by id 
		/*try {
			System.out.println(serv.adjustCustomerBillAmount(1, 20.0f));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//2.direct save 
		//for me giving error if I am giving new cno.
		/*try {
			Customer cust=new Customer(55,"Rohith","Adilabad",68000f);
			System.out.println(serv.registerOrUpdateCustomerDetails(cust));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//deleteById
		/*try {
			System.out.println(serv.removeCustomerById(5));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//delete
		/*try {
			Customer cust=new Customer();
			cust.setCno(3);
			System.out.println(serv.deleteCustomer(cust));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//deleteAll
		/*try {
			System.out.println(serv.deleteAllCustomers());
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//deleteAllById
		/*try {
			System.out.println(serv.removeAllCustomersByIds(List.of(8,110,54,685,325)));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}

}
