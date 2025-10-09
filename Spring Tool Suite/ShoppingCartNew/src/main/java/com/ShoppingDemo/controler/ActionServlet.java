package com.ShoppingDemo.controler;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;

import com.ShoppingDemo.model.Cart;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

public class ActionServlet extends HttpServlet{
	
	private ConfigurableApplicationContext ctx;


	private RequestProcessor rq;
	
	public ActionServlet() {
		// TODO Auto-generated constructor stub
		rq=new RequestProcessor();
	}
	
	public void setCtx(ConfigurableApplicationContext ctx) {
		this.ctx = ctx;
		
	}
	
	

	public void doGet(HttpServletRequest req,HttpServletResponse res) {
		System.out.println("this is running");
		//Call the request processor and pass the information to it 
		HttpSession session = req.getSession();
		if(session.getAttribute("Cart")==null) {
			Cart c=new Cart();
			session.setAttribute("Cart", c);
		}
		rq.setCtx(ctx);
		rq.doProcess(req, res);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		doGet(req,res);
	}
}
