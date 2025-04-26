package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.DrivingLicense;
import com.nt.document.Person;
import com.nt.repository.IDrivingLicenseRepository;
import com.nt.repository.IPersonRepository;

@Service("onetooneserv")
public class OneToOneAssociationManagementServiceImpl implements IOneToOneAssociationManagementService {

	@Autowired
	private IDrivingLicenseRepository drivrepo;
	@Autowired
	private IPersonRepository perrepo;
	
	@Override
	public String saveDataUsingPerson(Person person) {
		String idVal=perrepo.save(person).getId();
		return "Person object and its associated DrivingLicense object is saved with id value:: "+idVal;
	}

	@Override
	public String saveDataUsingLicense(DrivingLicense license) {
		String idVal=drivrepo.save(license).getId();
		return "Driving License object and its associated Person object is saved with id value:: "+idVal;
	}

	@Override
	public List<Person> showDataUsingPerson() {
		return perrepo.findAll();
	}

	@Override
	public List<DrivingLicense> showDataUsingDrivingLicense() {
		return drivrepo.findAll();
	}

}
