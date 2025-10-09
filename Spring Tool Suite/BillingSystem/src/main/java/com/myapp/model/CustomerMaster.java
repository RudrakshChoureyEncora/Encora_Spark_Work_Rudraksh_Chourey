package com.myapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CustomerMaster {

	@Id
	private int custid;
	private String cname;
	private String caddress;
	
	@OneToMany(mappedBy = "customer")
	private List<InvoiceMaster> invoices;
	
	public List<InvoiceMaster> getInvoices() {
		return invoices;
	}
	public void setInvoices(List<InvoiceMaster> invoices) {
		this.invoices = invoices;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	
	
	
}
