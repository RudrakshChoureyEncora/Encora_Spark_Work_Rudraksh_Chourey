package com.UnitTestingMockito.model;

import jakarta.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name="userMockito")
public class Users {
	@Id
	private Long userid;
	private String name;
	public Long getId() {
		return userid;
	}
	public void setId(Long id) {
		this.userid = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public Users(Long id, String name) {
		this.userid = id;
		this.name = name;
	} 
	
	
	
}
