package com.nt.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;

import com.nt.Customer.Customer;

@Controller
public class CustomerMapper implements RowMapper<Customer>{

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		 int id = rs.getInt("id");
		 String name = rs.getString("name");
		 String doc = rs.getString("doc");
		 String type = rs.getString("type");
		 String address = rs.getString("address");
		 int balance = rs.getInt("balance");
		 int minbal = rs.getInt("minbal");
		 String status = rs.getString("status");
		 
		 Customer c = new Customer(id, name, doc, type, address, balance, minbal, status);
		return c;
	}

	
}
