package com.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginAction extends Action{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) {
		String uname=req.getParameter("uname");
		System.out.println(uname);
		if(uname.equals("ramu")) return "login.success";
		else return "login.failure";
	}
}
