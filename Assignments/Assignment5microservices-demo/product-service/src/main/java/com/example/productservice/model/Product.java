package com.example.productservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
public class Product {
	@Id
	@Schema(name = "prod id", description = "this is the id of the prod")
	private long id;
	
	@Schema(name = "prod name", description = "this is the name of the product")
	private String Name ;
	
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
