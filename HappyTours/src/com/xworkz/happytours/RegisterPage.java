package com.xworkz.happytours;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.happytours.dao.HappyTourUserDao;
import com.xworkz.happytours.dao.impl.HappyTourUserDaoImpl;

public class RegisterPage extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside RegisterPageServlet");
		
		String firstNameStr = req.getParameter("firstname");
		String lastNameStr = req.getParameter("lastname");
		String emailIdStr = req.getParameter("emailid");
		String userNameStr = req.getParameter("username");
		String passwordStr = req.getParameter("password");
		
		System.out.println("First name entered in web client: "+ firstNameStr);
		System.out.println("Last name entered in web client: "+ lastNameStr);
		System.out.println("emailid entered in web client: "+emailIdStr);
		System.out.println("user name entered in web client: "+userNameStr);
		System.out.println("password entered in web client: "+passwordStr);
		
		String outputHtml = null;
		
		// check if record exist in DB
		// select count(*) from happytourUser where emailid= emailIdStr;
		HappyTourUserDao dao = new HappyTourUserDaoImpl();
		
		
		if(emailIdStr.equals("krupalj@gmail.com")) { 
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("sucessfulReg.html"); //html , servlet , jsp
			requestDispatcher.forward(req, resp);
			
		}else {
			dao.save(); //--> insert into table
			/*
			 * outputHtml = "<html>" + "<body>" + "<h1>"
			 * +" Congragulations you are successfully registered"
			 * +" <a href='login'>Click here to login</a>" + "</h1>" + "</body>" +
			 * "</html>"; PrintWriter out = resp.getWriter(); out.write(outputHtml);
			 */
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login"); //html , servlet , jsp
			requestDispatcher.forward(req, resp);
		}
		
		
		
	}

}
