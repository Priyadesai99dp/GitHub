package com.nt.Customer;

public class Customer {
	private int id;
	private String name;
	private String doc;
	private String type;
	private String address;
	private int balance;
	private int minbal;
	private String status;
	
	public Customer() {
		super();
	}
	
	

	public Customer(int id, String name, String doc, String type, String address, int balance, int minbal,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.doc = doc;
		this.type = type;
		this.address = address;
		this.balance = balance;
		this.minbal = minbal;
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDoc() {
		return doc;
	}



	public void setDoc(String doc) {
		this.doc = doc;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public int getMinbal() {
		return minbal;
	}



	public void setMinbal(int minbal) {
		this.minbal = minbal;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	
}
