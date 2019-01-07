package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderRepository;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderRepository.ProductDetail;

@Service
public class OrderServiceImpl extends PaymentDetailService implements OrderService {
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public void uploadOrder(List<Orders> orders) {
		for (Orders order : orders) {
			orderRepo.save(order);
		}
		
	}

	@Override
	public Orders findOrder(Long orderID) {
		Orders od = orderRepo.findById(orderID).get();
		return od;
	}

	@Override
	public List<ProductDetail> findProductDetail(Long orderID) {
		return orderRepo.findProductDetail(orderID);
	}


	@Override
	public List<Object> payDetail(Long orderID) {
		List<Object> obj = getDetailPaymentQuery(orderID);
		return obj;
	}

}
