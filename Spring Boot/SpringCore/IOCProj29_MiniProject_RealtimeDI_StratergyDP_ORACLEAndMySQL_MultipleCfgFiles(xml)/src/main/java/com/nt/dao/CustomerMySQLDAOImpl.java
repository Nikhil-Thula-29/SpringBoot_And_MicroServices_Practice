package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;


@Repository("custDAO-MySQL")
public class CustomerMySQLDAOImpl implements ICustomerDAO {
	
	private final String CUSTOMER_INFO_INSERT_QUERY="INSERT INTO SPRING_CUSTOMER_INFO(CNAME,CADDRS,BILLAMOUNT,DISCOUNT,FINALAMOUNT) VALUES(?,?,?,?,?)";

	int count=0;
	
	@Autowired
	private DataSource ds;
	
	@Override
	public int insert(Customer cust) throws Exception{
		
		try(Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement(CUSTOMER_INFO_INSERT_QUERY);) {
			
			//to set the values;
			ps.setString(1,cust.getCname());
			ps.setString(2, cust.getCadd());
			ps.setDouble(3, cust.getBillAmount());
			ps.setDouble(4, cust.getDiscount());
			ps.setDouble(5, cust.getFinalAmount());
			//to execute the query...
			count=ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();	//exception rethrowing for exception propagation..
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();	//exception rethrowing for exception propagation..
			throw e;
		}
		return count;
	}

}
