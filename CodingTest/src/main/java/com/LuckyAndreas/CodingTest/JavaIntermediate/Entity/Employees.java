package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="`Employees`")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employees {
	
	@Id
	@Column(name="`EmployeeID`")
	private Long EmployeeID;
	@Column(name = "`FirstName`")
	private String FirstName;
	@Column(name = "`LastName`")
	private String LastName;
	@Column(name = "`Title`")
	private String Title;
	@Column(name = "`WorkPhone`")
	private String WorkPhone;
	
	public Long getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getWorkPhone() {
		return WorkPhone;
	}
	public void setWorkPhone(String workPhone) {
		WorkPhone = workPhone;
	}
	
	
	

}
