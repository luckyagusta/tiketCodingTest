package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Customers;

public interface CustomerService {
	public void uploadCustomer(List<Customers> customers);
	public List<Customers> findCustomers();
	public Customers findCustomer(Long customerID);
}
