package com.LogginSession.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompKey {
	private String itemid;
	private String invid;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getInvid() {
		return invid;
	}
	public void setInvid(String invid) {
		this.invid = invid;
	}
	
	
}
