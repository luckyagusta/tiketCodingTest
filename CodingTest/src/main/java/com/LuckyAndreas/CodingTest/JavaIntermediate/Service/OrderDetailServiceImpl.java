package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.OrderDetails;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	private OrderDetailRepository odRepo;

	@Override
	public void uploadOrderDetail(List<OrderDetails> ods) {
		for (OrderDetails orderDetails : ods) {
			odRepo.save(orderDetails);
		}
		
	}

}
