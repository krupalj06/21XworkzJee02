package com.xworkz.happytours;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello there im in Servlet");
		
		String htmlcontent = "<html> "
				+ "<body> "
				+ "<h3> Welcome to Happy tours</h3>"  
				+ "<h3>plan you vacations here </h3>"
				+ "</body>"
				+ "</html>";
	
		PrintWriter out = resp.getWriter();
		out.write(htmlcontent);
		
	}
	
	
}
