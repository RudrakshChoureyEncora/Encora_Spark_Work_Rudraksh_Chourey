package com.LogginSession.controller;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
@WebFilter("*")
public class SessionFilter implements Filter{
 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		// TODO Auto-generated method stub
		 System.out.println("this is running");
		 HttpServletRequest hreq=(HttpServletRequest) request;
		 HttpServletResponse hres=(HttpServletResponse) response;
		 HttpSession session=hreq.getSession();
		 String s=hreq.getRequestURI();
		 String st[]=s.split("/");
		 String redMapping =st[st.length-1].split(";")[0];
		 System.out.println("this is="+redMapping);
		 if(session.isNew()) {
			 if(redMapping.equals("Login")) {
				 chain.doFilter(request, response);
			 }else{
				 request.getRequestDispatcher("/views/sessionexpired.jsp").forward(request, response);
			 }
		 }
		 else {
			 chain.doFilter(request, response);
			 
		 }
		
	}
}
