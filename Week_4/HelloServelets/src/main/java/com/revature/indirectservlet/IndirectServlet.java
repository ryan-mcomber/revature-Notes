package com.revature.indirectservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndirectServlet
 */
public class IndirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	// init() method is abstracted away!
	// Tomcat invokes the init() method when the URl is hit
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// let's redirect the user to some separate static resource
		//response.sendRedirect("http://localhost:8080/HelloServelets/dirserv"); 
		
		response.sendRedirect("http://localhost:8080/HelloServelets/somepage.html");// we can redirect the user to a separate page.
	}

	//What is the difference between sendRedirect() and forward() from the REquestDispatcher
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rdis = request.getRequestDispatcher("/dirserv");
		
		rdis.forward(request, response);
	}
}
