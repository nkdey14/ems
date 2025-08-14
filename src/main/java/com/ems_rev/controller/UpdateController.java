package com.ems_rev.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems_rev.service.DBServiceImpl;
@WebServlet("/updateReg")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			DBServiceImpl service = new DBServiceImpl();
			service.connectDB();
			ResultSet result = service.getRegistrationById(id);
			
			if(result.next()) {
				String name = result.getString(2);
				String course = result.getString(3);
				String email = result.getString(4);
				String mobile = result.getString(5);
				
				request.setAttribute("name", name);
				request.setAttribute("course", course);
				request.setAttribute("email", email);
				request.setAttribute("mobile", mobile);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
		    rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
