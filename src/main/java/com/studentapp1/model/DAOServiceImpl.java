package com.studentapp1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
private Connection con;
private  Statement stmnt;
	@Override
	public boolean verifylogin(String email, String password) {
		try {
			
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp1","root","Sa@14253669");
		  Statement stmnt = con.createStatement();*/
			
		  ResultSet result =stmnt.executeQuery("select * from login where email='"+email+"' and  password ='"+password+"'");
		  return result.next();
		 
		} catch (Exception e) {
		e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
		
		  stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		  
		 
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			
			  stmnt.executeUpdate("delete from registration where email='"+email+"'");
			  
			 
			} catch (Exception e) {
			e.printStackTrace();
			}
	}

	@Override
	public void updateRegistration(String email, String mobile) {

	}

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentapp1","root","Sa@14253669");
		 stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void closeDB() {
		
	}

	@Override
	public ResultSet listAllReg() {
          try {
		
		  ResultSet result =stmnt.executeQuery("select * from Registration");
		  return result;
		 
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}

}
