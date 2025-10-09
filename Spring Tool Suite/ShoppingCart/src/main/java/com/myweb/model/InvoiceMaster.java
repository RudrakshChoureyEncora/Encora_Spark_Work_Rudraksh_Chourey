package com.myweb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class InvoiceMaster implements Serializable{

	@Id
	private String invoiceid;
	private LocalDate invoicedate;
	public String getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	public LocalDate getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(LocalDate invoicedate) {
		this.invoicedate = invoicedate;
	}
	
	@ManyToOne
	@JoinColumn(name="customerid")
	private CustomerInfo customerinfo;
	public CustomerInfo getCustomerinfo() {
		return customerinfo;
	}
	public void setCustomerinfo(CustomerInfo customerinfo) {
		this.customerinfo = customerinfo;
	}
	
	@OneToMany(mappedBy="compKey")
	List<InvoiceTransaction> invTransact;
	
}
