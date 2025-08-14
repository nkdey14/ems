package com.ems_rev.service;

import java.sql.ResultSet;

public interface DBService {
	public void connectDB();
	public boolean verifyLogin(String email, String password);
	public int getUserId(String email);
	public void saveRegistration(String name, String course, String email, String mobile, int userId);
	public ResultSet getRegistrationsByUser(int userId);
	public void deleteRegById(int id);
	public ResultSet getRegistrationById(int id);

}
