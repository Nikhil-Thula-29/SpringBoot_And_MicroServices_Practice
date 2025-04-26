package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Component
public class HQLQueryTestRunner implements CommandLineRunner{

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		/*repo.getAllCustomers().forEach(System.out::println);
		//equal to
		System.out.println("==================");
		repo.getAllCustomers().forEach(val->{
			System.out.println(val);
		});
		
		System.out.println("==================");
		repo.getCustomersByBillamtRange(1000f, 100000f).forEach(System.out::println);
		
		System.out.println("==================");
		List<Object[]> list=repo.getCustomerData("Kiran", "vamshi");
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
		
		
		System.out.println("==================");
		List<String> list1=repo.findCustomerAddrsByNameChars("j%");
		list1.forEach(addrs->{
			System.out.println(addrs);
		});
		
		
		//if we have hyd more than one then it give error
		System.out.println("==================");
		Customer cust=repo.findCustomerDataByAddrs("hyd");
		System.out.println(cust);
		
		
		
		System.out.println("==================");
		Object obj=repo.fetchCustomerDetailsByAddrs("hyd");
		Object data[]=(Object[])obj;
		System.out.println("customer details::"+Arrays.toString(data));
		
		
		System.out.println("==================");
		System.out.println("Customer name:: "+repo.fetchCustomerNameByAddrs("vizag"));
		
		
		
		System.out.println("==================");
		System.out.println("Customers count:: "+repo.fetchAllCustomerCount());
		
		System.out.println("==================");
		System.out.println("Customers count:: "+repo.getAllCustomerCount());
		
		System.out.println("==================");
		Object aggregateData[]=(Object[])repo.fetchCustomerAggregateData();
		System.out.println("count:: "+aggregateData[0]);
		System.out.println("maxbillamt:: "+aggregateData[1]);
		System.out.println("minbillamt:: "+aggregateData[2]);
		System.out.println("avgbillamt:: "+aggregateData[3]);
		System.out.println("sum of billamt:: "+aggregateData[4]);*/
		
		
		

		
	}
	
	

}
