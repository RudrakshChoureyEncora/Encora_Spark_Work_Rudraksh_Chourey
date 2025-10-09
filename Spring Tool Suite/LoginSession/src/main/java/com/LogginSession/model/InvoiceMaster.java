package com.LogginSession.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InvoiceMaster {
	@Id
	private String invid;
	private LocalDateTime invdate;
	public String getInvid() {
		return invid;
	}
	public void setInvid(String invid) {
		this.invid = invid;
	}
	public LocalDateTime getInvdate() {
		return invdate;
	}
	public void setInvdate(LocalDateTime invdate) {
		this.invdate = invdate;
	}
	
}
