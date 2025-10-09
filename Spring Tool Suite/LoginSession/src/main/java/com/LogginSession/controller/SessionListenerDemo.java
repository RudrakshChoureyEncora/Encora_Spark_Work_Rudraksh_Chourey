package com.LogginSession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.LogginSession.model.User;
import com.LogginSession.service.UserService;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;



@Component
@WebListener
public class SessionListenerDemo implements HttpSessionListener{

	@Autowired
	@Qualifier("uServ1")
	private UserService uServ;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionCreated(se);
		System.out.println("session created");
	}
	
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession s=se.getSession();
		System.out.println("session expired logout my user"+s.getAttribute("userObj"));
		System.out.println(s.getId());
		uServ.doLogout(((User)s.getAttribute("userObj")).getUserid());
		HttpSessionListener.super.sessionDestroyed(se);
	}
}
