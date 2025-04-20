package com.nt.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.service.IOneToOneAssociationManagementService;

@Component
public class OneToOneAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IOneToOneAssociationManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*//saving data using parent i.e person
		Person per=new Person("raja","hyd",40);
		DrivingLicense license=new DrivingLicense("LMV",LocalDate.now(),LocalDate.of(2025,12,24));	
		//add child to parent
		per.setLicenseDetails(license);
		try {
			System.out.println(serv.saveDataUsingPerson(per));
		}catch(Exception e) { 
			e.printStackTrace();
		}*/
		
		
		//saving data using child i.e DrivingLicense
		/*DrivingLicense license = new DrivingLicense("HMV", LocalDate.now(), LocalDate.of(2025, 10, 12));
		Person per = new Person("Ganesh","Karimnagar",35);
		// add parent to child
		license.setPersonDetail(per);
		try {
			System.out.println(serv.saveDataUsingLicense(license));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		//findAll by person
		serv.showDataUsingPerson().forEach(per->{
			System.out.println("Parent:: "+per);
			DrivingLicense lic=per.getLicenseDetails();
			System.out.println("child:: "+lic);
		});
		
		System.out.println("========================");
		
		//findAll by DrivingLicense
		serv.showDataUsingDrivingLicense().forEach(license -> {
			System.out.println("child:: "+license);
			Person per=license.getPersonDetail();
			System.out.println("parent:: "+per);
		});
	}

}
