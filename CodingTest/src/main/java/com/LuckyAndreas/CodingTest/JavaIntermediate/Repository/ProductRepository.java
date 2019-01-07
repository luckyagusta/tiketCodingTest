package com.LuckyAndreas.CodingTest.JavaIntermediate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long>, PagingAndSortingRepository<Products, Long> {

}
