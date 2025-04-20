package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeekerInfo;
import com.nt.repository.IJobSeekerInfoRepository;

@Service("jsService")
public class JobSeekerManagementServiceImp implements IJobSeekerManagementService {

	@Autowired
	private IJobSeekerInfoRepository repo;
	
	@Override
	public String saveJobSeeker(JobSeekerInfo info) {
		Integer idVal=repo.save(info).getJsid();
		return "JobSeeker is registered with the Id value:: "+idVal;
	}

	@Override
	public List<JobSeekerInfo> showAllJobSeekers() {
		return repo.findAll();
		
	}

	@Override
	public String fetchResumePathById(Integer id) {
		return repo.getResumePathByJsId(id);
	}

	@Override
	public String fetchPhotoPathById(Integer id) {
		return repo.getPhotoPathByJsId(id);
	}

}
