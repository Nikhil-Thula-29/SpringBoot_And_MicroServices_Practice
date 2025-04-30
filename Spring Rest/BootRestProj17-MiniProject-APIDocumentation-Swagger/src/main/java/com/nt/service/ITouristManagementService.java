package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;

public interface ITouristManagementService {

	public String registerTourist(Tourist tourist);
	public List<Tourist> showAllTourist();
	public List<Tourist> showTouristByBudgetRange(double start,double end);
	public Tourist showTouristById(int id)throws TouristNotFoundException;
	public String modifyTourist(Tourist tourist);
	public String modifyTouristBudgetById(int id,double hikePercentage);
	public String removeTouristById(int id);
	public String removeTouristsByPackageType(String type);
	
} 
