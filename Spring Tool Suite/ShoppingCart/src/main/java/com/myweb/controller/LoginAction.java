package com.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myweb.services.CustomerServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("login")
public class LoginAction extends Action{
	@Autowired
	private CustomerServiceImpl CusServ;
@Override
public String execute(HttpServletRequest req, HttpServletResponse res) {
	// TODO Auto-generated method stub
	String uname=req.getParameter("uname");
	String upass=req.getParameter("upass");
	System.out.println("s1");
	if(CusServ.checkuser(uname)) {
		System.out.println("s2");
		if(CusServ.checkUserPass(uname,upass)) {
			System.out.println("s3");
			return "login.success";
		}else return "login.WrongPass";
	}else return "login.Register";
	
}
}
