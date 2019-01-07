package com.LuckyAndreas.CodingTest.JavaIntermediate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Long>, PagingAndSortingRepository<Employees, Long> {

}
