package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Employees;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.EmployeeRepository;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	OrderRepository orderRepo;

	@Override
	public void uploadEmployee(List<Employees> emp) {
	for (Employees employees : emp) {
		employeeRepository.save(employees);
	}
	}

	@Override
	public Employees findEmployee(Long employeeID) {
		Employees emp = employeeRepository.findById(employeeID).get();
		return emp;
	}

	@Override
	public List<Employees> findEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Object> findEmployeeByOrder() {
		List<Object> listEmp = new ArrayList<>();
		
		List<Orders> orders = orderRepo.findAll();
		for (Orders order : orders) {
			Map<String, Object> map = new HashMap<>();
			Employees emp = new Employees();
			emp = order.getEmployee();
			map.put("EmployeeID", emp.getEmployeeID());
			map.put("FirstName", emp.getFirstName());
			map.put("LastName", emp.getLastName());
			map.put("Title", emp.getTitle());
			map.put("WorkPhone", emp.getWorkPhone());
			map.put("OrderID", order.getOrderID());
			listEmp.add(map);	
		}
		
		
		return listEmp;
	}

}
