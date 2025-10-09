package com.myweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.myweb.controller.ActionServlet;

@SpringBootApplication(exclude = {
	        org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.class,
	        org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration.class,
	        org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration.class

	    })
@ServletComponentScan
@ComponentScan("com")
public class StrutsShoiabApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= 
				SpringApplication.run(StrutsShoiabApplication.class, args);
		
		ServletRegistrationBean<ActionServlet> srb=ctx.getBean("getServlet",ServletRegistrationBean.class);
		ActionServlet as=srb.getServlet();
		as.setCtx(ctx);
	}

}
