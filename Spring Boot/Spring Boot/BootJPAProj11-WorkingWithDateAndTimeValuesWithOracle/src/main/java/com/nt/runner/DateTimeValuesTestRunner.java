package com.nt.runner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Student;
import com.nt.service.IStudentManagementService;


@Component	//imp to rem
public class DateTimeValuesTestRunner implements CommandLineRunner{

	@Autowired
	private IStudentManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Student stud=new Student();
			stud.setSname("Nikhil Thula");
			stud.setSaddrs("Warangal");
			stud.setDob(LocalDateTime.of(2001, 07, 29, 05,26, 30));
			stud.setDoa(LocalDate.now());
			stud.setToa(LocalTime.now());
			String msg=serv.registerStudent(stud);
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//findAll()
		//serv.getAllStudnets().forEach(System.out::println);
		
	}

}
