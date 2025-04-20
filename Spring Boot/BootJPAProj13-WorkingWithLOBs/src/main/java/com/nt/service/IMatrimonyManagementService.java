package com.nt.service;

import com.nt.entity.MarriageSeeker;

public interface IMatrimonyManagementService {

	public String registerMarriageSeeker(MarriageSeeker seeker);
	
	public MarriageSeeker getMarriageSeekerById(Long id);
	
}
