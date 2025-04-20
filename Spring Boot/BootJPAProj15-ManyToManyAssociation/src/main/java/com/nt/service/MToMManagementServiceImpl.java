package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.repository.IDoctorRepository;
import com.nt.repository.IPatientRepository;


@Service("mtmservice")
public class MToMManagementServiceImpl implements IMToMManagementService {

	@Autowired
	private IDoctorRepository docrepo;
	@Autowired
	private IPatientRepository patrepo;
	
	//save by doctors
	
	@Override
	public void saveDataUsingDoctor() {
		Doctor doc1=new Doctor("raja","physican");
		Doctor doc2=new Doctor("Anil","rmp");
		Doctor doc3=new Doctor("vamshi","dermatology");

		
		Patient pat1=new Patient("karan",40,"heart");
		Patient pat2=new Patient("rajesh",25,"bp");
		Patient pat3=new Patient("ramesh",32,"stomach");
		Patient pat4=new Patient("rakesh",43,"kidney");
		
		
		//add patients to doctors
		//Always use mutable list i.e ArrayList<> not direct List,of() orelse it gives error
		doc1.setPatients(new ArrayList<>(List.of(pat1,pat2)));
		doc2.setPatients(new ArrayList<>(List.of(pat2,pat3,pat4)));
		doc3.setPatients(new ArrayList<>(List.of(pat2,pat4)));
				
		//add doctors to patients
		pat1.setDoctors(new ArrayList<>(List.of(doc1)));
		pat2.setDoctors(new ArrayList<>(List.of(doc2,doc3)));
		pat3.setDoctors(new ArrayList<>(List.of(doc3)));
		pat4.setDoctors(new ArrayList<>(List.of(doc2)));
		
			
		
		docrepo.saveAll(Arrays.asList(doc1,doc2,doc3));
		System.out.println("Doctors and patients are saved..");	//rem use saveAll
		
	}

	//save by patient

	@Override
	public void saveDataUsingPatient() {
		Doctor doc1=new Doctor("sharan","physican");
		Doctor doc2=new Doctor("shashi","rmp");
		Doctor doc3=new Doctor("anvesh","dermatology");

		
		Patient pat1=new Patient("hemanth",40,"brain");
		Patient pat2=new Patient("sathish",25,"sugar");
		Patient pat3=new Patient("jagdessh",32,"head");
		Patient pat4=new Patient("anitha",43,"liver");
		
		
		//add patients to doctors
		//Always use mutable list i.e ArrayList<> not direct List,of() orelse it gives error
		doc1.setPatients(new ArrayList<>(List.of(pat1,pat2)));
		doc2.setPatients(new ArrayList<>(List.of(pat2,pat3,pat4)));
		doc3.setPatients(new ArrayList<>(List.of(pat2,pat4)));
				
		//add doctors to patients
		pat1.setDoctors(new ArrayList<>(List.of(doc1)));
		pat2.setDoctors(new ArrayList<>(List.of(doc2,doc3)));
		pat3.setDoctors(new ArrayList<>(List.of(doc3)));
		pat4.setDoctors(new ArrayList<>(List.of(doc2)));
					
		
		patrepo.saveAll(Arrays.asList(pat1,pat2,pat3,pat4));
		System.out.println("Patients and doctors are saved..");	//rem use saveAll
		
	}

	@Override
	public void loadDataUsingDoctor() {
		List<Doctor> list=docrepo.findAll();
		list.forEach(doc->{
			System.out.println("Doctors list are:: "+doc);
			List<Patient> listpat=doc.getPatients();
			listpat.forEach(pat->{
				System.out.println("Patients list are:: "+pat);
			});
			System.out.println("==================");
		});
		
	}

	@Override
	public void loadDataUsingPatient() {
		List<Patient> list=patrepo.findAll();
		list.forEach(pat->{
			System.out.println("Patients list are:: "+pat);
			List<Doctor> listdoc=pat.getDoctors();
			listdoc.forEach(doc->{
				System.out.println("Doctors list are:: "+doc);
			});
			System.out.println("==============");
		});
		
	}

}
