package com.ShoppingDemo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer implements Serializable{
	
	@Id
	private String custmerid;
	private String customername;
	private String customerpass;
	private boolean iscustomerloggedin;
	public String getCustmerid() {
		return custmerid;
	}
	public void setCustmerid(String custmerid) {
		this.custmerid = custmerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerpass() {
		return customerpass;
	}
	public void setCustomerpass(String customerpass) {
		this.customerpass = customerpass;
	}
	public boolean isIscustomerloggedin() {
		return iscustomerloggedin;
	}
	public void setIscustomerloggedin(boolean iscustomerloggedin) {
		this.iscustomerloggedin = iscustomerloggedin;
	}
	
	
	
	
}
