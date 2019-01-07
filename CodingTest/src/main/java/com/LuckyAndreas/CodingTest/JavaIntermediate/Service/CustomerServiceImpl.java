package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Customers;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public void uploadCustomer(List<Customers> customers) {
		for (Customers customer : customers) {
			customerRepo.save(customer);
		}		
	}
	
	@Override
	public List<Customers> findCustomers(){
		return customerRepo.findAll();
	}

	@Override
	public Customers findCustomer(Long customerID) {
		Customers customer = customerRepo.findById(customerID).get();
		return customer;
	}

}
