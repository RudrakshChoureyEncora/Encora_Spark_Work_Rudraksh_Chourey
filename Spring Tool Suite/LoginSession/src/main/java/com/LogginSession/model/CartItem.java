package com.LogginSession.model;


public class CartItem{
	Item item;
	int quantity=0;
	public CartItem(Item i,int q) {
		// TODO Auto-generated constructor stub
		this.item=i;
		this.quantity=q;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
