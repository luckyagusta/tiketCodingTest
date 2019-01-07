package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`Shipping_Methods`")
public class ShippingMethods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6278100271847461560L;
	@Id
	@Column(name = "`ShippingMethodID`")
	private Long ShippingMethodID;
	@Column(name = "`ShippingMethod`")
	private String ShippingMethod;
	
	public Long getShippingMethodID() {
		return ShippingMethodID;
	}
	public void setShippingMethodID(Long shippingMethodID) {
		ShippingMethodID = shippingMethodID;
	}
	public String getShippingMethod() {
		return ShippingMethod;
	}
	public void setShippingMethod(String shippingMethod) {
		ShippingMethod = shippingMethod;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
