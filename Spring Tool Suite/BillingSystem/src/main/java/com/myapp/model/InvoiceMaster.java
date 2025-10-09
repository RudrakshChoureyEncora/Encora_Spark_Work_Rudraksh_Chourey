package com.myapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class InvoiceMaster implements Serializable {
	
	@Id
	private int billno;
	private Date billdate;
	private int discount;
	
	@ManyToOne
	@JoinColumn(name = "customerid", referencedColumnName = "custid")
	private CustomerMaster customer;
	
	@OneToMany(mappedBy = "invoices", cascade = CascadeType.ALL)
	private List<ItemTransaction> transactions;
	
	public CustomerMaster getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerMaster customer) {
		this.customer = customer;
	}
	public int getBillno() {
		return billno;
	}
	public void setBillno(int billno) {
		this.billno = billno;
	}
	public Date getBilldate() {
		return billdate;
	}
	public void setBilldate(Date l) {
		this.billdate = l;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}	
}
