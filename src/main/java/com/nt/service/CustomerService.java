package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.Customer.Customer;
import com.nt.Mapper.CustomerMapper;
import com.nt.Repository.CustomerRepository;

@Component
public class CustomerService {

	@Autowired
	private CustomerRepository rep;

	public boolean insert(Customer c) {
		return rep.insert(c);
	}

	public boolean update(Customer c) {
		return rep.update(c);
	}

	public boolean delete(int id) {
		return rep.delete(id);
	}

	public Customer select(int id) {
		return rep.select(id);
	}

	public List<Customer> selectall(Customer c) {
		return rep.selectall(c);
	}

	public List<Customer> type(String type) {
		return rep.type(type);
	}

	public List<Customer> area(String address) {
		return rep.area(address);
	}

	public List<Customer> status(String status) {
		return rep.status(status);
	}

	public int bal(Customer c) {
		return rep.bal(c);
	}

}
