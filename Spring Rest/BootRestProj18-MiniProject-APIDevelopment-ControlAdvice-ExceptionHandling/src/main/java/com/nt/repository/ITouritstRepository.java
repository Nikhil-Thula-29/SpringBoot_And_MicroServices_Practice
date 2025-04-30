package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouritstRepository extends JpaRepository<Tourist, Integer>{

	@Query("from Tourist where budget>=:start and budget<=:end")
	public List<Tourist> searchTouristsByBudgetRange(double start,double end);
	
	
	@Query("delete from Tourist where packageType=:type")
	@Modifying
	@Transactional
	public int deleteTouristByPackageType(String type);
}
