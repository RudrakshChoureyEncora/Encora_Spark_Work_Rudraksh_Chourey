package com.ShoppingDemo.service;


public interface CustomerService {
	public abstract  boolean checkUser(String cusId);
	public abstract boolean checkUserPass(String cusId,String cusPass);
	public abstract boolean checkUserFlag(String cusId);
}
