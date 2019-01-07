package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "`Orders`")
public class Orders extends DateUtil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9162381526956415645L;
	
	@Id
	@Column(name="`OrderID`")
	private Long OrderID;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`CustomerID`", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Customers customer;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`EmployeeID`", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Employees employee;
	@Column(name = "`PurchaseOrderNumber`")
	private String PurchaseOrderNumber;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "`ShippingMethodID`", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private ShippingMethods shippingMethods;
	@Column(name = "`FreightCharge`")
	private Long FreightCharge;
	@Column(name = "`Taxes`")
	private Long Taxes;
	@Column(name = "`PaymentReceived`")
	private char PaymentReceived;
	@Column(name = "`Comment`")
	private String Comment;

	public Long getOrderID() {
		return OrderID;
	}

	public void setOrderID(Long orderID) {
		OrderID = orderID;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	
	
	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}

	public ShippingMethods getShippingMethods() {
		return shippingMethods;
	}

	public void setShippingMethods(ShippingMethods shippingMethods) {
		this.shippingMethods = shippingMethods;
	}

	public Long getFreightCharge() {
		return FreightCharge;
	}

	public void setFreightCharge(Long freightCharge) {
		FreightCharge = freightCharge;
	}

	public Long getTaxes() {
		return Taxes;
	}

	public void setTaxes(Long taxes) {
		Taxes = taxes;
	}

	public char getPaymentReceived() {
		return PaymentReceived;
	}

	public void setPaymentReceived(char paymentReceived) {
		PaymentReceived = paymentReceived;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

}
