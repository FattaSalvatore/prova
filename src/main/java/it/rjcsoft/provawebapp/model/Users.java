package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Users {
	private Connection con;
	
	public Users(Connection con) {
		this.con = con;
	}
	
	public boolean InsertUser(String name, String surname, String cf, String BirthDate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement("Insert into test1_users (nome, cognome, cf, datanascita) VALUES (?,?,?,?)");
		prst.setString(1, name);
		prst.setString(2, surname);
		prst.setString(3, cf);
		prst.setString(4, BirthDate);
		return prst.execute();
	}
	
	public ResultSet SelectUser(String cf) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement("Select * from test1_users WHERE cf = ?");
		prst.setString(1, cf);
		prst.execute();
		ResultSet rs = prst.getResultSet();
		if(!rs.next()) {
			rs = null;
		}
		return rs;
	}
}
