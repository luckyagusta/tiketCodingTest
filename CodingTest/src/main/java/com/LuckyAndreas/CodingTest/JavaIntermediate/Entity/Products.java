package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="`Products`")
public class Products implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5612014159866648472L;
	
	@Id
	@Column(name="`ProductID`")
	private Long ProductID;
	@Column(name="`ProductName`")
	private String ProductName;
	@Column(name="`UnitPrice`")
	private Double UnitPrice;
	@Column(name="`InStock`")
	private char InStock;
	
	public Long getProductID() {
		return ProductID;
	}
	public void setProductID(Long productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		UnitPrice = unitPrice;
	}
	public char getInStock() {
		return InStock;
	}
	public void setInStock(char inStock) {
		InStock = inStock;
	}
	
	
}
