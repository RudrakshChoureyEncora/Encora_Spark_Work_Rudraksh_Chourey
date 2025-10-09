package com.myweb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerInfo implements Serializable{
	
	@Id
	private String customerid;
	private String Customername;
	private String customerpass;
	private boolean isLoggedIn;
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public List<InvoiceMaster> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<InvoiceMaster> invoices) {
		this.invoices = invoices;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return Customername;
	}
	public void setCustomername(String customername) {
		Customername = customername;
	}
	public String getCustomerpass() {
		return customerpass;
	}
	public void setCustomerpass(String customerpass) {
		this.customerpass = customerpass;
	}
	
	@OneToMany
	(mappedBy = "customerinfo", cascade = CascadeType.ALL)
	private List<InvoiceMaster> invoices=new ArrayList<>();
	
}
