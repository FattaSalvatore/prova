package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CredenzialiDB {
	private Connection con;
	private String QueryInsertCredenziali="Insert into test1_credenziali (email,pwd,iduser) VALUES (?,?,?)";
	private String QueryDeleteCredenziali="DELETE FROM test1_credenziali WHERE email = ?";
	private String QuerySelectCredenziali="Select * from test1_credenziali WHERE email = ?";
	private String QueryUpdateCredenziali="Update test1_credenziali set  email=?, pwd=?, ruolo=? where email=?";
	
	public CredenzialiDB(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertCredenziali(String email, String pwd,String id ) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryInsertCredenziali); //Preparazione dello statement
		prst.setString(1, email);
		prst.setString(2, pwd);
		prst.setInt(3, Integer.parseInt(id));
		return prst.execute(); //esecuzione dello statement (ritorna true se andato a buon fine)
	
	}
	
	public ResultSet selectCredenziali(String email) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QuerySelectCredenziali); //Preparazione dello statement
		prst.setString(1, email);
		prst.execute();
		ResultSet rs = prst.getResultSet(); // Esecuzione della SELECT
		if(!rs.next()) {
			rs = null;
		}
		return rs;
	}
	
	public boolean DeleteCredenziali(String email) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryDeleteCredenziali);
		prst.setString(1, email);
		return prst.execute();
	}
	

	public ResultSet UpdateCredenziali(String email,String pwd,String ruolo) throws SQLException{
		PreparedStatement prst = this.con.prepareStatement(QueryUpdateCredenziali);
		prst.setString(1, email);
		prst.setString(2, pwd);
		prst.setString(3, ruolo);
		prst.setString(4, email);
		prst.execute();
		ResultSet rs = prst.getResultSet();
		if(!rs.next()) {
			rs = null;
		}
		return rs;
		
	}
	
}
