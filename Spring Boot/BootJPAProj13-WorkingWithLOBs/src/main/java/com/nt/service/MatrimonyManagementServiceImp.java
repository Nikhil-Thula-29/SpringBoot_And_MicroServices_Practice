package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.MarriageSeeker;
import com.nt.repository.IMarriageManagementSeekerRepository;


@Service("matriserv")
public class MatrimonyManagementServiceImp implements IMatrimonyManagementService {

	@Autowired
	private IMarriageManagementSeekerRepository repo;
	
	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker) {
		long idVal=repo.save(seeker).getMid();
		return "Marriage Seeker is registered with the Id value:: "+idVal;
	}

	@Override
	public MarriageSeeker getMarriageSeekerById(Long id) {
		return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}

}
