package com.ShoppingDemo.controler;

import java.util.Enumeration;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ShoppingDemo.model.Cart;
import com.ShoppingDemo.model.Item;
import com.ShoppingDemo.repository.ItemRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("shopping")
public class ShoppingAction extends Action{

	@Autowired
	ItemRepo iRepo;

   
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		Enumeration<String> e=req.getParameterNames();
		Cart c=(Cart)req.getSession().getAttribute("Cart");
		
		while(e.hasMoreElements()){
			System.out.println();
			String s=req.getParameter(e.nextElement());
			System.out.println(s);
			Optional<Item> i=iRepo.findById(s);
			System.out.println(i);
			if(i.isPresent()) {
				c.addToCart(i.get(), 1);
			}else System.out.println("The item with this id is not there");
			
		}
		
		String s=req.getParameter("next");
		System.out.println(s);
		return s;
	}
}
