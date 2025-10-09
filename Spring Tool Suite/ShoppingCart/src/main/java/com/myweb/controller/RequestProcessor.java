package com.myweb.controller;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.context.ConfigurableApplicationContext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestProcessor {

	private ConfigurableApplicationContext ctx;
	
	public void setCtx(ConfigurableApplicationContext ctx) {
		this.ctx=ctx;
	}
	
	public void doProces(HttpServletRequest req,HttpServletResponse res) {
		try {
			ServletContext application=req.getServletContext();
			String path=application.getRealPath("/WEB-INF/config.properties");
			System.out.println("path...:"+path);
			Properties prop=new Properties();
			prop.load(new FileInputStream(path));
			String actionid=req.getParameter("actionid");
			System.out.println("action id..:"+actionid);
			if(actionid==null) {
				System.out.println("forwarding............................");
				req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, res);
			}
			else {
			Action actionobj=(Action)ctx.getBean(actionid);
			String result=actionobj.execute(req, res);
			String nextpage=prop.getProperty(result);
			req.getRequestDispatcher(nextpage).forward(req, res);
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
}
