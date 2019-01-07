package com.LuckyAndreas.CodingTest.JavaIntermediate.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.OrderDetails;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Products;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.OrderDetailRepository;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private OrderDetailRepository odRepo;

	@Override
	public void uploadProducts(List<Products> products) {
		for (Products product : products) {
			productRepo.save(product);
		}	
	}

	@Override
	public Products findProduct(Long productID) {
		Products prod = productRepo.findById(productID).get();
		return prod;
	}

	@Override
	public List<Object> findProductByOrder() {
		List<Object> listProd = new ArrayList<>();
		List<OrderDetails> orderDetail = odRepo.findAll();
		for (OrderDetails od : orderDetail) {
			Map<String, Object> map = new HashMap<>();
			Products prod = new Products();
			Orders order = new Orders();
			order = od.getOrder();
			prod = od.getProduct();
			map.put("OrderID", order.getOrderID());
			map.put("OrderDetailID", od.getOrderDetailID());
			map.put("ProductName", prod.getProductName());
			map.put("Quantity", od.getQuantity());
			map.put("UnitPrice", "$"+od.getUnitPrice());
			map.put("Discount", "$"+od.getDiscount());
			Long disc = od.getDiscount();
			if(disc != 0){
				Double subTotal = od.getUnitPrice() * disc / 100;
			map.put("SubTotal", "$"+subTotal);
			}
			else{
				map.put("SubTotal", "$"+od.getUnitPrice());
			}
			listProd.add(map);
			
		}
		return listProd;
	}

}
