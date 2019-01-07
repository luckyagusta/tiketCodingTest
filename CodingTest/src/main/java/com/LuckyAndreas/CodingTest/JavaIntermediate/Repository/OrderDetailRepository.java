package com.LuckyAndreas.CodingTest.JavaIntermediate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.OrderDetails;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long>, PagingAndSortingRepository<OrderDetails, Long> {

}
