package com.ems_rev.service;

import java.sql.*;

public class DBServiceImpl implements DBService{
	Connection con=null;
	Statement stmnt = null;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emsdb2","root","test");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from user where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getUserId(String email) {
		try {
			ResultSet result = stmnt.executeQuery("select * from user where email='"+email+"'");
			if(result.next()) {
			 return result.getInt(1);
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void saveRegistration(String name, String course, String email, String mobile, int userId) {
		try {
			int id=0;
			stmnt.executeUpdate("insert into registration values('"+id+"','"+name+"','"+course+"','"+email+"','"+mobile+"','"+userId+"')");
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public ResultSet getRegistrationsByUser(int userId) {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration where user_id='"+userId+"'");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRegById(int id) {
		try {
			stmnt.executeUpdate("delete from registration where id='"+id+"'");
			
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public ResultSet getRegistrationById(int id) {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration where id='"+id+"'");
			return result;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

}
