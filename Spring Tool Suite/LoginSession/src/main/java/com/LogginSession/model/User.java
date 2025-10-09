package com.LogginSession.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	private String userid;
	private String userpass;
	private int flag;
	private String sessionid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpass() {
		return userpass;
	}
	
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	public int getFlag() {
		return flag;
	}
	
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public String getSessionid() {
		return sessionid;
	}
	
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.userid + this.userpass + this.flag;
	}
	
}
