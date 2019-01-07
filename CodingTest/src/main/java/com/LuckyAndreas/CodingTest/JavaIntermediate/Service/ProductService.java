package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Products;

public interface ProductService {
	public void uploadProducts(List<Products> products);
	public Products findProduct(Long productID);
	public List<Object> findProductByOrder();
}
