package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "`OrderDate`", "`ShipDate`" }, allowGetters = true)

public abstract class DateUtil implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -6203815851863958776L;
	
	@Column(name = "`OrderDate`", nullable = true, updatable = true)
	private Date OrderDate;
	@Column(name = "`ShipDate`", nullable = true, updatable = true)
	private Date ShipDate;

	public Date getShipDate() {
		return ShipDate;
	}

	public void setShipDate(String date) throws ParseException {
		Date dateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(date); 
		ShipDate = dateFormat;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String date) throws ParseException {
		Date dateFormat= new SimpleDateFormat("dd/MM/yyyy").parse(date);  
		OrderDate = dateFormat;
	}

}
