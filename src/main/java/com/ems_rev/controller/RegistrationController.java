package com.ems_rev.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems_rev.service.DBServiceImpl;
@WebServlet("/saveReg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String emailId = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		HttpSession session = request.getSession(false);
		String email = (String)session.getAttribute("email");
		DBServiceImpl service = new DBServiceImpl();
		service.connectDB();
		int userId = service.getUserId(email);
	
		service.saveRegistration(name, course, emailId, mobile, userId);
		
		request.setAttribute("message", "Record is saved");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		rd.forward(request, response);
	}

}
