package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repository.IStudentRepositoryManagement;


@Service("studserv")
public class StudentManagementService implements IStudentManagementService{

	@Autowired	
	private IStudentRepositoryManagement repo;
	
	@Override
	public String registerStudent(Student stud) {
		int idVal=repo.save(stud).getSno();
		return "Student is saved with the id value: "+idVal;
	}

	@Override
	public List<Student> getAllStudnets() {
		List<Student> list=repo.findAll();
		return list;
	}

}
