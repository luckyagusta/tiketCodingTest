package com.LuckyAndreas.CodingTest.JavaIntermediate.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`Customers`")
public class Customers implements Serializable {

	private static final long serialVersionUID = 8834319987246364224L;
	@Id
	@Column(name="`CustomerID`")
	private Long CustomerID;
	@Column(name="`CompanyName`")
	private String CompanyName;
	@Column(name = "`FirstName`")
	private String FirstName;
	@Column(name = "`LastName`")
	private String LastName;
	@Column(name = "`BillingAddress`")
	private String BillingAddress;
	@Column(name = "`City`")
	private String City;
	@Column(name = "`StateOrProvince`")
	private String StateOrProvince;
	@Column(name = "`ZIPCode`")
	private String ZIPCode;
	@Column(name = "`Email`")
	private String Email;
	@Column(name = "`CompanyWebsite`")
	private String CompanyWebSite;
	@Column(name = "`PhoneNumber`")
	private String PhoneNumber;
	@Column(name = "`FaxNumber`")
	private String FaxNumber;
	@Column(name = "`ShipAddress`")
	private String ShipAddress;
	@Column(name = "`ShipCity`")
	private String ShipCity;
	@Column(name = "`ShipStateOrProvince`")
	private String ShipStateOrProvince;
	@Column(name = "`ShipZIPCode`")
	private String ShipZIPCode;
	@Column(name = "`ShipPhoneNumber`")
	private String ShipPhoneNumber;
	
	public Long getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Long customerID) {
		this.CustomerID = customerID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
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

	public String getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStateOrProvince() {
		return StateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		StateOrProvince = stateOrProvince;
	}

	public String getZIPCode() {
		return ZIPCode;
	}

	public void setZIPCode(String zIPCode) {
		ZIPCode = zIPCode;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getCompanyWebSite() {
		return CompanyWebSite;
	}

	public void setCompanyWebSite(String companyWebSite) {
		CompanyWebSite = companyWebSite;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return FaxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		FaxNumber = faxNumber;
	}

	public String getShipAddress() {
		return ShipAddress;
	}

	public void setShipAddress(String shipAddress) {
		ShipAddress = shipAddress;
	}

	public String getShipCity() {
		return ShipCity;
	}

	public void setShipCity(String shipCity) {
		ShipCity = shipCity;
	}

	public String getShipStateOrProvince() {
		return ShipStateOrProvince;
	}

	public void setShipStateOrProvince(String shipStateOrProvince) {
		ShipStateOrProvince = shipStateOrProvince;
	}

	public String getShipZIPCode() {
		return ShipZIPCode;
	}

	public void setShipZIPCode(String shipZIPCode) {
		ShipZIPCode = shipZIPCode;
	}

	public String getShipPhoneNumber() {
		return ShipPhoneNumber;
	}

	public void setShipPhoneNumber(String shipPhoneNumber) {
		ShipPhoneNumber = shipPhoneNumber;
	}
	
	
	
	
	

}
