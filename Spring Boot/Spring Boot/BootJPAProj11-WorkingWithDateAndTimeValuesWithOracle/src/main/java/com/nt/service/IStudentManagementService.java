package com.nt.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Student;

public interface IStudentManagementService {

	@Transactional
	public String registerStudent(Student stud);
	
	public List<Student> getAllStudnets();
}
