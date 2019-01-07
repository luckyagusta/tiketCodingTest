package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.OrderDetails;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderDetailRepository;


public class PaymentDetailService {
	@Autowired
	private OrderDetailRepository odRepo;
	
	public List<Object> getDetailPaymentQuery(long orderID) {
		List<Object> obj = new ArrayList<>();
		List<Double> objCount = new ArrayList<>();
		List<OrderDetails> tempList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		List<OrderDetails> odlist = odRepo.findAll();
		;
		for (OrderDetails orderDetail : odlist) {

			if (orderDetail.getOrder().getOrderID() == orderID) {
				OrderDetails od = new OrderDetails();
				od.setQuantity(orderDetail.getQuantity());
				od.setUnitPrice(orderDetail.getUnitPrice());
				od.setDiscount(orderDetail.getDiscount());
				map.put("Taxes", orderDetail.getOrder().getTaxes());
				map.put("Shipping & handling", orderDetail.getOrder().getFreightCharge());
				tempList.add(od);
			}
		}
		double subtotal = 0;
		for (int i = 0; i < tempList.size(); i++) {
			double price = tempList.get(i).getUnitPrice();
			Long qty = tempList.get(i).getQuantity();
			double discount = tempList.get(i).getDiscount();
			if (discount != 0) {
				subtotal = (price * qty) - ((price * qty * discount) / 100);
			} else {
				subtotal = (price * qty);
			}
			objCount.add(subtotal);

		}
		double sum = objCount.stream().mapToInt(Double::intValue).sum();
		map.put("Order Subtotal", sum);
		double pajak = (Long) map.get("Taxes");
		double ongkir = (Long) map.get("Shipping & handling");
		double ot = sum + pajak + ongkir;
		map.put("Order Total", ot);

		obj.add(map);

		return obj;
	}
}
