package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderRepository.ProductDetail;

public interface OrderService {
	public void uploadOrder(List<Orders> orders);
	public Orders findOrder(Long orderID);
	public List<ProductDetail> findProductDetail(Long orderID);
	public List<Object> payDetail(Long orderID);
}
