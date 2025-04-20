package com.nt.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection="Employee_Info")	//for mongo db like entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	private String id;
	@NonNull
	private Integer eno;
	@NonNull
	private String ename;
	@NonNull
	private String eaddrs;
	@NonNull
	private Double salary;
	@NonNull
	private boolean isVaccinated;
}
