package com;
import java.io.FileInputStream;
import java.sql.ResultSetMetaData;
import java.util.Properties;

import com.model.Action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestProcessor {
	public void doProcess(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			ServletContext application = req.getServletContext();
			String realPath=application.getRealPath("/WEB-INF/config.properties");
			Properties prop=new Properties();
			prop.load(new FileInputStream(realPath));
			String action= req.getParameter("action");
			String actionClass=prop.getProperty(action);
			Action actionobj=(Action)Class.forName(actionClass).getConstructor().newInstance();
			String result = actionobj.execute(req, resp);
			String nextPage=prop.getProperty(result);
			RequestDispatcher rd= req.getRequestDispatcher(nextPage);
			rd.forward(req, resp);
			
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
