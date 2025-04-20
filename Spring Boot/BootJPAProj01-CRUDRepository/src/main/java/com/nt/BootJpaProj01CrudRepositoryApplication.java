package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.entity.Customer;
import com.nt.service.ICustomerManagementService;

@SpringBootApplication
public class BootJpaProj01CrudRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootJpaProj01CrudRepositoryApplication.class, args);
		/*ICustomerManagementService serv=ctx.getBean("custservice",ICustomerManagementService.class);
		try {
			Customer cust=new Customer();
			cust.setCname("Vijay");
			cust.setCaddrs("Sangareddy");
			cust.setBillamt(50000.00f);
			String resultmsg=serv.registerCustomer(cust);
			System.out.println(resultmsg);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
	}

}
