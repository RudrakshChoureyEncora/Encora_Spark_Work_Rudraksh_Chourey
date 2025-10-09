package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class HelloServlet
 */



/*
 * 
 * it is multithreaded and alows muultiple user 
 * tabs are multiple conversations and multiple browsers are multiple users
 * creates one object snd uses its instances 
 * 
 * no need to write more code it will make it sequential for all other users and make it slow 
 * thus follow a controller logic dont write business logic over here
 * 
 * page redirection or page navigation 
 * response sender object 
 * request dispatcher object 
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public HelloServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get called....");
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		System.out.println(uname+":"+upass);
		if(uname.equals("ramu")) {
			//response.sendRedirect("welcome.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		
	}

}
