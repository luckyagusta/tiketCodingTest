package com.LuckyAndreas.CodingTest.JavaIntermediate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.LuckyAndreas.CodingTest.JavaIntermediate.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>, PagingAndSortingRepository<Orders, Long> {
	
	@Query(value = "select "
		 	+" o.\"OrderID\" as orderID, "
			+"	 p.\"ProductName\" as prodName, "
			+"	 od.\"Quantity\" as quantity, "
			+"	 od.\"UnitPrice\" as hargaSatuan, "
			+"	 od.\"Discount\" as diskon, "
			+"	 CASE "
			+"	 	WHEN od.\"Discount\">0 THEN (od.\"UnitPrice\"* od.\"Quantity\")-((od.\"UnitPrice\"* od.\"Quantity\"*od.\"Discount\")/100) "
			+"	 	ELSE (od.\"UnitPrice\"* od.\"Quantity\") "
			+"	 	END "
			+"	 	AS subTotal "
			+"	 from public.\"Orders\" o " 
			+"	 inner join public.\"Order_Details\" od on od.\"OrderID\" = o.\"OrderID\" "
			+"	 inner join public.\"Products\" p on p.\"ProductID\" = od.\"ProductID\" "
			+"	 where o.\"OrderID\" = :orderID" , nativeQuery = true)
	public List<ProductDetail> findProductDetail(@Param("orderID") Long orderID);
	
	 public static interface ProductDetail {
		 Long getOrderID();
	     String getProdName();
	     Long getQuantity();
	     Double getHargaSatuan();
	     Long getDiscount();
	     Double getSubTotal();
	  }
}
