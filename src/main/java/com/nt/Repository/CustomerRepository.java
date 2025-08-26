package com.nt.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.nt.Customer.Customer;
import com.nt.Mapper.CustomerMapper;

@Controller
public class CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insert(Customer c) {
		try {
			Object[] args = { c.getId(), c.getName(), c.getAddress(), c.getDoc(), c.getType(), c.getBalance(),
					c.getMinbal(), c.getStatus() };
			int result = jdbcTemplate.update("insert into customer values(?,?,?,?,?,?,?,?)", args);
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Customer c) {
		try {
			Object[] args = {  c.getName(), c.getAddress(), c.getDoc(), c.getType(), c.getBalance(),
					c.getMinbal(), c.getStatus(),c.getId() };
			int result = jdbcTemplate.update("update customer set name=?,address=?,doc=?,type=?,balance=?,minbal=?,status=? where id = ?", args);
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			Object[] args = { id };
			int result = jdbcTemplate.update("delete from customer where id = ?", args);
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Customer select(int id) {
			try {
			Object[] args = { id };
			Customer c = jdbcTemplate.queryForObject("select * from customer where id = ?", new CustomerMapper(), args);
			if (c != null) {
				return c;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Customer> selectall(Customer c) {
		try {
			List<Customer> list = jdbcTemplate.query("select * from customer", new CustomerMapper());
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Customer> type(String type) {
		try {
			Object[] args = { type };
			List<Customer> list = jdbcTemplate.query("select * from customer where type = ?", new CustomerMapper(),
					args);
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Customer> area(String address) {
		try {
			Object[] args = { address };
			List<Customer> list = jdbcTemplate.query("select * from customer where address = ?", new CustomerMapper(),
					args);
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Customer> status(String status) {
		try {
			Object[] args = { status };
			List<Customer> list = jdbcTemplate.query("select * from customer where status = ?", new CustomerMapper(),
					args);
			if (list != null) {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int bal(Customer c) {
		try {
			int a = jdbcTemplate.update("update customer set balance = balance-500 where minbal<5000");
			if (a == 1) {
				return a;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

}
