package com.LuckyAndreas.CodingTest.JavaIntermediate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.ShippingMethods;

@Repository
public interface ShippingMethodRepository extends JpaRepository<ShippingMethods, Long>, PagingAndSortingRepository<ShippingMethods, Long> {

}
