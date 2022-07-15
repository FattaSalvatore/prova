package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsersDB {
	private Connection con;
	private String QueryInsertUser="Insert into test1_users (nome, cognome, cf, datanascita) VALUES (?,?,?,?)";
	private String QueryDeleteUser="DELETE FROM test1_users WHERE id = ?";
	private String QuerySelectUser="Select * from test1_users tu JOIN test1_roles tr ON tr.id=ruolo_id JOIN test1_credenziali tc ON tc.iduser=tu.id WHERE tu.id = ?";
	private String QuerySelectUser2="Select * from test1_users tu WHERE tu.cf = ?";
	private String QueryUpdateUser="Update test1_users set nome=?, cf=? where id=?";
	private String QuerySelectAllUsers="Select * from test1_users tu INNER JOIN test1_roles tr ON tr.id=tu.ruolo_id INNER JOIN test1_credenziali tc ON tc.iduser = tu.id";
	
	private String id="id";
	private String nome="nome";
	private String cognome="cognome";
	private String cf="cf";
	private String datanascita="datanascita";
	private String ruolo="ruolo";
	
	public UsersDB(Connection con) {
		this.con = con;
	}
	
	public boolean InsertUser(String name, String surname, String cf, Date BirthDate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryInsertUser);
		prst.setString(1, name);
		prst.setString(2, surname);
		prst.setString(3, cf);
		prst.setDate(4, BirthDate);
		return prst.execute();
	}
	
	public boolean InsertUser2(String email, String pwd, String name, String surname, String cf, Date BirthDate,int ruolo) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryInsertUser);
		CredenzialiDB cred=new CredenzialiDB(this.con);
		cred.insertCredenziali(email, pwd, ruolo);
		prst.setString(1, name);
		prst.setString(2, surname);
		prst.setString(3, cf);
		prst.setDate(4, BirthDate);
		
		return prst.execute();
	}
	

	public boolean DeleteUser(int id) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryDeleteUser);
		prst.setInt(1, id);
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
	
	public ResultSet SelectUser2(String cf) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QuerySelectUser2);
		prst.setString(1, cf);
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
	
	public ArrayList<User> selectAllUsers() throws SQLException{
		List<User> lu=new ArrayList<User>();
		PreparedStatement prst = this.con.prepareStatement(QuerySelectAllUsers);  //Preparazione dello statement
		prst.execute();
		ResultSet rs = prst.getResultSet(); // Esecuzione della SELECT
		while(rs.next()) {
			lu.add(new User(rs.getInt(id),rs.getString(nome),rs.getString(cognome),rs.getString(cf),rs.getDate(datanascita), rs.getString(ruolo)));
		
		}
			
		return (ArrayList<User>) lu;
	
		
	}
}
