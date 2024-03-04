package com.mvc.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.bean.Registerbean;
import com.mvc.dao.Registerdao;

public class RegisterServlet extends HttpServlet {
 
	 public RegisterServlet() {
	 }

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 
		 Registerbean registerBean = new Registerbean();
	
		 registerBean.setFullName(fullName);
		 registerBean.setEmail(email);
		 
		 registerBean.setPassword(password); 
		 
		 Registerdao Registerdao = new Registerdao();
		 
		
		 String emailRegistered = Registerdao.email(registerBean);
		 
		 if(emailRegistered.equals("SUCCESS"))   {
			request.getRequestDispatcher("/home1.jsp").forward(request, response);
		 }
		 else   
		 {
			request.setAttribute("errMessage", emailRegistered);
			request.getRequestDispatcher("/registration.jsp").forward(request, response);
		 }
	 }
}