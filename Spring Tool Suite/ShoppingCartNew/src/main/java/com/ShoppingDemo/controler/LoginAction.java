package com.ShoppingDemo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ShoppingDemo.service.CustomerServiceImpl;
import com.ShoppingDemo.service.ItemServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loginabc")
public class LoginAction extends Action{
	
	@Autowired
	private CustomerServiceImpl cusServ;
	@Autowired
	private ItemServiceImpl iServ;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		System.out.println(req.getParameter("uid")+" "+req.getParameter("upass"));
		if (cusServ.checkUser(req.getParameter("uid"))) {
			if(cusServ.checkUserPass(req.getParameter("uid"),req.getParameter("upass"))) {
				if(cusServ.checkUserFlag(req.getParameter("uid"))) {
						req.getSession().setAttribute("Shop1Prod",iServ.getShopItem("shop1") );
						req.getSession().setAttribute("Shop2Prod",iServ.getShopItem("shop2") );
						req.getSession().setAttribute("Shop3Prod",iServ.getShopItem("shop3") );
					return "login.shop1";
				}
				else return "login.already";
			}
			else return"login.wrongPass";
		}
		else return "login.register";
	}
}
