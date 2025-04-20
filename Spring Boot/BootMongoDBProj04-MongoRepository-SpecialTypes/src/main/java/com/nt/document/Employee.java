package com.nt.document;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection="Employee_special_types")	//for mongo db like entity
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
	private String[] favColors;
	@NonNull
	private List<String> friends;
	@NonNull
	private Set<Long> phoneNumbers;
	@NonNull
	private Properties idDetails;	//properties is also map<-,-> key value pairs
	@NonNull
	private Map<Integer,String> insurancePolocies;
}
