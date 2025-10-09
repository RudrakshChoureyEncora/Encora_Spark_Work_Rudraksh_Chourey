package com.LogginSession.model;

import java.util.ArrayList;
import java.util.List;


public class Cart {
	List<CartItem> listOfItems=new ArrayList<>();
	int totalPrice;
	
	public CartItem addToCart(Item item,int quantity) {
		if(quantity>0) {
			if(listOfItems.size()==0) {
				CartItem ci=new CartItem(item,quantity);
				listOfItems.add(ci);
				totalPrice=item.getItemprice()*quantity;
				return ci;
			}else {
				for(CartItem cI:listOfItems) {
					if(cI.getItem().getItemid().equals(item.getItemid()) ) {
						cI.setQuantity(cI.getQuantity()+quantity);
						totalPrice+=item.getItemprice()*quantity;
						return cI;
					}
				}
				totalPrice+=item.getItemprice()*quantity;
				CartItem c=new CartItem(item,quantity);
				listOfItems.add(c);
				return c;
			}
		}
		return null;
	}

	public List<CartItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<CartItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}

