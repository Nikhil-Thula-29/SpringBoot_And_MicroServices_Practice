package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface IStudentManagementService {

	public String registerStudent(Student stud);
	
	public List<Student> getAllStudnets();
}
