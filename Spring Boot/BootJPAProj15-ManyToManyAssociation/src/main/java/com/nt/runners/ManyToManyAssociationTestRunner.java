package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IMToMManagementService;


@Component
public class ManyToManyAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IMToMManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		//serv.saveDataUsingDoctor();
		
		//serv.saveDataUsingPatient();

		serv.loadDataUsingDoctor();
		
		serv.loadDataUsingPatient();
	}

}
