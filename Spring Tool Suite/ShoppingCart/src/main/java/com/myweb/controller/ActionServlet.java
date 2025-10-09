package com.myweb.controller;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ActionServlet extends HttpServlet{
	private RequestProcessor rp;
	private ConfigurableApplicationContext ctx;
	public ActionServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("servlet loaded....");
		rp=new RequestProcessor();
	}
	public void setCtx(ConfigurableApplicationContext ctx) {
		this.ctx=ctx;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		rp.setCtx(ctx);
		
		rp.doProces(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
