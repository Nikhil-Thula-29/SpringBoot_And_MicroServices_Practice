package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;



/*CREATE OR REPLACE PROCEDURE P_GET_CUSTOMERS_BY_BILLAMT_RANGE 
(
  STARTAMOUNT IN FLOAT 
, ENDAMOUNT IN FLOAT 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
  OPEN DETAILS FOR
  SELECT * FROM JPA_CUSTOMER_TAB WHERE BILLAMT>=STARTAMOUNT AND BILLAMT<=ENDAMOUNT;
END P_GET_CUSTOMERS_BY_BILLAMT_RANGE;*/

@Service("custservice")
public class CustomerManagementServiceImp implements ICustomerManagementService{

	
	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Customer> getCustomerByBillAmountRange(double start, double end) {
		//create storedprocedure query object
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_CUSTOMERS_BY_BILLAMT_RANGE",Customer.class);
		//register the PL/SQL procedure parameter with java data types
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3, Object.class, ParameterMode.REF_CURSOR); //indirectly registering as OUT param and rem object
		
		
		//set values to IN params
		query.setParameter(1, start);
		query.setParameter(2,end);
		
		//call PL/SQL procedure
		List<Customer> list=query.getResultList();
		return list;
	}

}
