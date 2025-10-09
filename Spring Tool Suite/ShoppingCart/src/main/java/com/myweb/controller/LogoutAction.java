package com.myweb.controller;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("logout")
public class LogoutAction extends Action{
@Override
public String execute(HttpServletRequest req, HttpServletResponse res) {
	// TODO Auto-generated method stub
	return "logout.success";
}
}
