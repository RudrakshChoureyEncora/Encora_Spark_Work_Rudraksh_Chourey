package com.ShoppingDemo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ShoppingDemo.controler.ActionServlet;

@Configuration
public class ServletConfig {
	
	@Bean
	public ServletRegistrationBean<ActionServlet> getServlet() {
		ActionServlet as=new ActionServlet();
		ServletRegistrationBean<ActionServlet> srb=new ServletRegistrationBean<ActionServlet>(as,"*.do");
		srb.setLoadOnStartup(1);
		return srb;
	}
}
