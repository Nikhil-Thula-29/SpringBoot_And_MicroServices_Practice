package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyManagementService;


@Component
public class MatrimonyTestRunner implements CommandLineRunner{

	@Autowired
	private IMatrimonyManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter name:: ");
		String name=sc.nextLine();
		
		System.out.println("Enter Address:: ");
		String addrs=sc.nextLine();
		
		System.out.println("Enter DOB(yyyy-mm-ddThh:mm:ss:sss):: ");	//example:: 1999-06-26T12:30:20
		String dob=sc.nextLine();
		LocalDateTime ldob=LocalDateTime.parse(dob);
		
		System.out.println("Is Customer Indian? ");
		boolean indian=sc.nextBoolean();
		
		System.out.println("Enter photo file path:: ");
		String photoPath=sc.next();
		
		System.out.println("Enter resume file path:: ");
		String resumePath=sc.next();
		
		//create steams representing photo file,resume file
		//FileInputStream is used for byte by byte
		//create byte[] and char[] having data
		FileInputStream fis=new FileInputStream(photoPath);
		byte[] photoContent=fis.readAllBytes();
		
		//FileReader is used for text files
		File file=new File(resumePath);
		FileReader reader=new FileReader(resumePath);
		char[] resumeContent=new char[(int) file.length()];
		reader.read(resumeContent);
		
		//create model/entity class object
		MarriageSeeker seeker=new MarriageSeeker("raja","hyd",ldob,photoContent,resumeContent,indian);
		//save the object
		try {
			System.out.println(serv.registerMarriageSeeker(seeker));
		}catch (Exception e){
			e.printStackTrace();
		}*/
		
		
		//Load object operation
		MarriageSeeker seeker=serv.getMarriageSeekerById(1L);
		System.out.println(seeker.getMid()+" "+seeker.getName()+" "+seeker.getName()+" "+seeker.getDob());
		byte[] photoContent=seeker.getPhoto();
		char[] resumeContent=seeker.getResume();
		//write the content to destination files
		FileOutputStream fos=new FileOutputStream("retrive_photo.png");	//name of image will set that name for image
		fos.write(photoContent);
		fos.flush();
		fos.close();
		FileWriter writer=new FileWriter("retrive_resume.txt"); //name of retrived resume
		writer.write(resumeContent);
		writer.flush();
		writer.close();
	}

}
