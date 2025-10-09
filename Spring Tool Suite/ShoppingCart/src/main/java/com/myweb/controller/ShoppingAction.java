package com.myweb.controller;
import java.util.Enumeration;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Component("shopping")
public class ShoppingAction extends Action{
@Override
public String execute(HttpServletRequest req, HttpServletResponse res) {
		addToSession(req);
	return "ViewCart";
}

public void addToSession(HttpServletRequest req) {
	System.out.println("Adding to session");
	HttpSession session=req.getSession();
	Enumeration<String> e= req.getParameterNames();
	while(e.hasMoreElements()) {
		
		String name=e.nextElement();
		System.out.println(name);
		String value=req.getParameter(name);
		session.setAttribute(name, value);
	}
}
}