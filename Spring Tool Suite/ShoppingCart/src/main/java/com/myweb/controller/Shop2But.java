package com.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myweb.services.ItemsServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("Shop 2")
public class Shop2But extends Action{
	@Autowired
	ItemsServiceImpl itServ;
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		itServ.getShopItems("shop2").forEach(s->System.out.println(s.getItemname()));
		req.setAttribute("Products", itServ.getShopItems("shop2"));
		return "shop2";
	}
}
