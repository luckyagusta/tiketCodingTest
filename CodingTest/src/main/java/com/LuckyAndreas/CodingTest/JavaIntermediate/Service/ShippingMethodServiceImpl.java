package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.ShippingMethods;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderRepository;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.ShippingMethodRepository;

@Service
public class ShippingMethodServiceImpl implements ShippingMethodService {
	@Autowired
	private ShippingMethodRepository smRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Override
	public void uploadShippingMethod(List<ShippingMethods> sm) {
		for (ShippingMethods shippingMethods : sm) {
			smRepo.save(shippingMethods);
		}
		
	}

	@Override
	public ShippingMethods findSM(Long smID) {
		ShippingMethods sm = smRepo.findById(smID).get();
		return sm;
	}

	@Override
	public List<Object> findShippingMethodByOrder() {
		List<Object> listSm = new ArrayList<>();
		List<Orders> orders = orderRepo.findAll();
		for (Orders order : orders) {
			Map<String, Object> map = new HashMap<>();
			ShippingMethods sm = new ShippingMethods();
			sm = order.getShippingMethods();
			map.put("OrderID", order.getOrderID());
			map.put("ShippingMethodID", sm.getShippingMethodID());
			map.put("ShippingMethod", sm.getShippingMethod());
			listSm.add(map);

		}
		return listSm;
	}

}
