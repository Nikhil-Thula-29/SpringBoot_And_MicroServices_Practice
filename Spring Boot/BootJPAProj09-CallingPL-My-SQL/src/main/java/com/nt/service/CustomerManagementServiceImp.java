package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

//mysql
/*DELIMITER $$

USE `springboot_microservices`$$

DROP PROCEDURE IF EXISTS `p_get_CustomerDetailsByBillAmt`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `p_get_CustomerDetailsByBillAmt`()
BEGIN

	SELECT * FROM JPA_CUSTOMER_TAB WHERE BILLAMT>=startAmount AND BILLAMT<=endAmount;
	
	END$$

DELIMITER ;*/


@Service("custservice")
public class CustomerManagementServiceImp implements ICustomerManagementService{

	//Entity manager is internally used by save and all other methods in crudrepo.
	//for mysql no need of separate repo file.
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Customer> getCustomerByBillAmountRange(double start, double end) {
		//create storedprocedure query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("p_get_CustomerDetailsByBillAmt",Customer.class);
		//register the PL/SQL procedure parameter with java data types
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		
		
		
		//set values to IN params
		query.setParameter(1, start);
		query.setParameter(2,end);
		
		//call PL/SQL procedure
		List<Customer> list=query.getResultList();
		return list;
	}

}
