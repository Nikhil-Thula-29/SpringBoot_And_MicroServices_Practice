package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;

public interface IJobSeekerManagementService {
	public String saveJobSeeker(JobSeekerInfo info);	//JobSeekerInfo->Entity and JobSeekerDetails-->ModelClass

	public List<JobSeekerInfo> showAllJobSeekers();
	
	public String fetchResumePathById(Integer id);
	
	public String fetchPhotoPathById(Integer id);
}
