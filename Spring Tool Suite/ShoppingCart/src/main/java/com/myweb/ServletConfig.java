package com.myweb;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myweb.controller.ActionServlet;

@Configuration
public class ServletConfig {

	@Bean
	public ServletRegistrationBean<ActionServlet> getServlet(){
		ServletRegistrationBean<ActionServlet> srb=
				new ServletRegistrationBean<>(new ActionServlet(),"*.do");
		srb.setLoadOnStartup(1);
		return srb;
	}
}
