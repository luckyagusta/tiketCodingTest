package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Employees;

public interface EmployeeService {
	public void uploadEmployee(List<Employees> emp);
	public Employees findEmployee(Long employeeID);
	public List<Employees> findEmployees();
	public List<Object> findEmployeeByOrder();
}
