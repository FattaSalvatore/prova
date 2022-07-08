package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBdriver {
	private static DBdriver dbdriver=null;
	private String connString=null;
	
	private DBdriver() {
		String driverString = "jdbc:postgresql://sviluppo.rjcsoft.it/test";

		try {
			Connection conn = DriverManager.getConnection(driverString);
			Class.forName(driverString).getDeclaredConstructor().newInstance();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static synchronized DBdriver getInstance() {
		if(dbdriver==null) {
			dbdriver=new DBdriver();
		}
		return dbdriver;
		
	}
	
	public String getConnString() {
		return connString;
	}
	
	public java.sql.Connection openConnection() {
		  java.sql.Connection conn = null;
		  try {
		   conn=DriverManager.getConnection(  
		     "jdbc:postgresql://sviluppo.rjcsoft.it/test","test_user","!$Av2kkm#KCnJFen2$57rjc");  
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  return conn;
		 }
		 
		 public void closeConnection(java.sql.Connection conn) {
		  try { conn.close(); }catch(Exception ex) {}
	}
}
