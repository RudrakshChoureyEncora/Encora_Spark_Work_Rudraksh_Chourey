package com.myweb.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompKey {
	private String invoicenumber;
	private String itemid;
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	
}
