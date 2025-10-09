package com.LogginSession.controller;

import java.io.IOException;
import java.util.List;

import com.LogginSession.model.Cart;
import com.LogginSession.model.CartItem;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class CartShowTag extends SimpleTagSupport{
	private Cart cart;
	
	
	
	
	public Cart getCart() {
		return cart;
	}




	public void setCart(Cart cart) {
		this.cart = cart;
	}




	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspWriter out = getJspContext().getOut();
		
		List<CartItem> ci=cart.getListOfItems();
		out.println("Total Number of Items: "+ci.size());

		  for (CartItem c : ci) {
		    	System.out.println(c.getItem().getItemname());
		        
		        out.write("<br>" +"----- Item Name: " + c.getItem().getItemname() + 
	                    " ----- Item Price: " + c.getItem().getItemprice() +  " ----- Item Quantity: "+"<input type=\"number\" value='"+c.getQuantity()+"'  name='"+c.getItem().getItemid()+"' >"+ " ----- Total Price: " + (c.getItem().getItemprice() * c.getQuantity())+"<br>");
		        
		        
		        
		    }
		  out.println("<br>--------------- Total Price of the Cart: " + cart.getTotalPrice() + "/- ---------------------------------------<br>");

	}

}
