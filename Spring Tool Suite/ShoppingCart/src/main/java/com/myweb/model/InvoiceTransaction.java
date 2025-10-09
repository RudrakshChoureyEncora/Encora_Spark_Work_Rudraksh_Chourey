package com.myweb.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InvoiceTransaction implements Serializable{
	
	@EmbeddedId
	@ManyToOne
	@JoinColumn(name="invoiceid")
	private CompKey compKey;
	
	private int qty;
	
	
	public CompKey getCompKey() {
		return compKey;
	}
	public void setCompKey(CompKey compKey) {
		this.compKey = compKey;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
