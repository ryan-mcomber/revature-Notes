 package com.revature.sessionservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		SuperVillain mudman = new SuperVillain("Mud Man","mud armor",300);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("the-villain", mudman);
		
		PrintWriter out = response.getWriter();
		
		out.write(new ObjectMapper().writeValueAsString(mudman));
		out.println("Mud man is on the loose and the session is set");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Capture the input from the HTTP post request and create a java object
		String name = request.getParameter("name");
		String superpower = request.getParameter("superpower");
		double bounty = Double.parseDouble(request.getParameter("bounty"));
		
		
		//2. convert the captured parameters into an object, by passing it thru the SuperVillain Constructor.
		SuperVillain vill = new SuperVillain(name,superpower,bounty);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("the-villain", vill);
		
		PrintWriter out = response.getWriter();
		out.write(new ObjectMapper().writeValueAsString(vill));
		out.println("A Villain is on the loose and the session is set");
		
		
	}

}
