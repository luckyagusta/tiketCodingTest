package com.LuckyAndreas.CodingTest.JavaIntermediate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long>, PagingAndSortingRepository<Customers, Long>  {
}
