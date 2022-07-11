package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersDB {
	private Connection con;
	private String QueryInsertUser="Insert into test1_users (nome, cognome, cf, datanascita) VALUES (?,?,?,?)";
	private String QueryDeleteUser="DELETE FROM test1_users WHERE id = ?";
	private String QuerySelectUser="Select * from test1_users WHERE id = ?";
	private String QueryUpdateUser="Update test1_user set nome=?, cf=? where id=?";
	public UsersDB(Connection con) {
		this.con = con;
	}
	
	public boolean InsertUser(String name, String surname, String cf, String BirthDate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryInsertUser);
		prst.setString(1, name);
		prst.setString(2, surname);
		prst.setString(3, cf);
		prst.setString(4, BirthDate);
		return prst.execute();
	}
	

	public boolean DeleteUser(int id) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryDeleteUser);
		prst.setInt(1, id);
		int i = 0;
		return prst.execute();
	}
	

	public ResultSet SelectUser(int id) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QuerySelectUser);
		prst.setInt(1, id);
		prst.execute();
		ResultSet rs = prst.getResultSet();
		if(!rs.next()) {
			rs = null;
		}
		return rs;
	}
	
	public ResultSet UpdateUser(String name,String cf,int id) throws SQLException{
		PreparedStatement prst = this.con.prepareStatement(QueryUpdateUser);
		prst.setString(1, name);
		prst.setString(2, cf);
		prst.setInt(3, id);
		prst.execute();
		ResultSet rs = prst.getResultSet();
		if(!rs.next()) {
			rs = null;
		}
		return rs;
		
	}
}
