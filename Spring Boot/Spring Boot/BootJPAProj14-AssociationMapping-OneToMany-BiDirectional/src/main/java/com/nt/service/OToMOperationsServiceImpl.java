package com.nt.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.entity.PhoneNumber;
import com.nt.repository.ICustomerRepository;
import com.nt.repository.IPhoneNumerRepository;


@Service("OTMService")
public class OToMOperationsServiceImpl implements IOToMOperationService {

	@Autowired
	private ICustomerRepository custrepo;
	@Autowired
	private IPhoneNumerRepository phonerepo;
	
	
	//saving data using customer--parent single customer always i.e one to many so use save
	@Override
	public void saveDataUsingCustomer() {
		//prepare data
		//parent
		Customer cust=new Customer("Anil","wgl");	//customer will be only one i.e one to many
		//child
		PhoneNumber ph1=new PhoneNumber(66666666L,"canteen","jio");
		PhoneNumber ph2=new PhoneNumber(55555555L,"home","vodafone");
		//link child to parent and viceversa
		Set<PhoneNumber> phoneset=new HashSet<PhoneNumber>();
		phoneset.add(ph1);
		phoneset.add(ph2);			//childs are linked with parent
		cust.setPhones(phoneset);
		ph1.setCustomer(cust);		//parent is linked with child
		ph2.setCustomer(cust);
		
		//save data using parent obj
		int idval=custrepo.save(cust).getCid();
		System.out.println("Customer obj and their child objs are saved with the id value:: "+idval);
	}

	
	//save using phonenumber--child multiple so use saveall--many to one
	@Override
	public void saveDataUsingPhoneNumber() {
		Customer cust=new Customer("Nikhil","Goa");	//only one customer
	
		PhoneNumber ph1=new PhoneNumber(654643654L,"balcony","airtel");
		PhoneNumber ph2=new PhoneNumber(214616494L,"office","bsnl");
		PhoneNumber ph3=new PhoneNumber(364661651L,"House","vi");
		Set<PhoneNumber> phoneset=new HashSet<PhoneNumber>();
		phoneset.add(ph1);
		phoneset.add(ph2);
		phoneset.add(ph3);
		
		ph1.setCustomer(cust);
		ph2.setCustomer(cust);
		ph3.setCustomer(cust);
		
		//save data using child i.e phonenumber
		/*int idval1=phonerepo.save(ph1).getRegno();
		int idval2=phonerepo.save(ph2).getRegno();*/
		Iterable<PhoneNumber> it=phonerepo.saveAll(phoneset);	//Imp: to save multiple data use saveAll not save it is giving error like collections hashset,multiple objects
		it.forEach(val->{
			System.out.println("PhoneNumber obj and their associated parent obj is saved with idval:: "+val.getRegno());
		});
		
	}


	@Override
	public void getDataUsingCustomer() {
		List<Customer> list=custrepo.findAll();
		list.forEach(val->{
			System.out.println("Parent:: "+val);
			Set<PhoneNumber> childs=val.getPhones();
			childs.forEach(ph->{
				System.out.println("child:: "+ph);
			});
		});
	}


	@Override
	public void getDataUsingPhoneNumber() {
		List<PhoneNumber> list=phonerepo.findAll();
		list.forEach(val->{
			System.out.println("child:: "+val);
			Customer cust=val.getCustomer();
			System.out.println("parent:: "+cust);		
		});
		
	}


	@Override
	public void deleteDataUsingCustomer(int id) {
		//load the parent obj
		Optional<Customer> opt=custrepo.findById(id);
		if(opt.isPresent()) {
			//get parent
			Customer cust=opt.get();
			custrepo.delete(cust);
			System.out.println("parent and its childs are deleted");
		}else {
			System.out.println("parent not found");
		}
	}

}
