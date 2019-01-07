package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="`Order_Details`")
public class OrderDetails implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1484995984515966974L;
	
	@Id
	@Column(name="`OrderDetailID`")
	private Long OrderDetailID;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`OrderID`", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Orders order;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`ProductID`", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Products product;
	@Column(name="`Quantity`")
	private Long Quantity;
	@Column(name="`UnitPrice`")
	private Double UnitPrice;
	@Column(name="`Discount`")
	private Long Discount;
	
	public Long getOrderDetailID() {
		return OrderDetailID;
	}
	public void setOrderDetailID(Long orderDetailID) {
		OrderDetailID = orderDetailID;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public Long getQuantity() {
		return Quantity;
	}
	public void setQuantity(Long quantity) {
		Quantity = quantity;
	}
	public Double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		UnitPrice = unitPrice;
	}
	public Long getDiscount() {
		return Discount;
	}
	public void setDiscount(Long discount) {
		Discount = discount;
	}
	
	

}
