package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.List;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.ShippingMethods;

public interface ShippingMethodService {
	public void uploadShippingMethod(List<ShippingMethods> sm);
	public ShippingMethods findSM(Long smID);
	public List<Object> findShippingMethodByOrder();
}
