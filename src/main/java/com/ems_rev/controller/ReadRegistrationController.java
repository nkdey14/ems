package com.ems_rev.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems_rev.service.DBServiceImpl;
@WebServlet("/readReg")
public class ReadRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReadRegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		    HttpSession session = request.getSession(false);
		    String email = (String)session.getAttribute("email");
		    
		    DBServiceImpl service = new DBServiceImpl();
			service.connectDB();
			int userId = service.getUserId(email);
			
			
			ResultSet result = service.getRegistrationsByUser(userId);
			
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registrations.jsp");
		    rd.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
