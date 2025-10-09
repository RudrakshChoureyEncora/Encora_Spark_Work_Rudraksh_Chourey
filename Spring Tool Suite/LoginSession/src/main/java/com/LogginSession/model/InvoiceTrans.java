package com.LogginSession.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class InvoiceTrans {
	
	@EmbeddedId
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
