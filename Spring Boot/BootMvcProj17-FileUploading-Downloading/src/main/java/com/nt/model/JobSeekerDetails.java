package com.nt.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;



//in this proj we are taking model and enity as separate bcz of we are storing resume and photo as multipart file while in db we are storing path as string that's why.

@Data
public class JobSeekerDetails implements Serializable{

	private Integer jsId;
	private String jsName;
	private String jsAddrs;
	private String jsQlfy;
	private MultipartFile resume;
	private MultipartFile photo;
	
}
