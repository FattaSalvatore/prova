package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Auto {
	private Connection con;
	private String QueryInsertAuto="Insert into test1_auto (marca, modello, targa, proprietario, prezzo_auto, datarevisione, inizio_polizza, fine_polizza ) VALUES (?,?,?,?,?,?,?,?)";
	private String QueryDeleteAuto="DELETE FROM test1_auto WHERE targa = ?";
	private String QuerySelectAuto="Select * from test1_auto WHERE id = ?";
	private String QueryUpdateAuto="Update test1_auto set  proprietario=?, prezzo_auto=?, datarevisione=?, inizio_polizza=?, fine_polizza=? where id=?";
	public Auto(Connection con) {
		this.con = con;
	}
	
	/* Inserimento di Auto */
	public boolean InsertAuto(String brand, String model, String l_Plate, String owner, String carPrice, String revisionDate, String startInsurancePolicy, String endInsurancePolicy ) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryInsertAuto); //Preparazione dello statement
		prst.setString(1, brand);
		prst.setString(2, model);
		prst.setString(3, l_Plate);
		prst.setString(4, owner);
		prst.setString(5, carPrice);
		prst.setString(6, revisionDate);
		prst.setString(7, startInsurancePolicy);
		prst.setString(8, endInsurancePolicy);
		return prst.execute(); //esecuzione dello statement (ritorna true se andato a buon fine)
	}
	
	/* Delete di Auto */
	public boolean DeleteAuto(String l_Plate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryDeleteAuto); //Preparazione dello statement
		prst.setString(1, l_Plate);
		return prst.execute(); //esecuzione dello statement (ritorna true se andato a buon fine)
	}
	
	/* Select di Auto */
	public ResultSet SelectAuto(int id) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QuerySelectAuto); //Preparazione dello statement
		prst.setInt(1, id);
		prst.execute();
		ResultSet rs = prst.getResultSet(); // Esecuzione della SELECT
		if(!rs.next()) {
			rs = null;
		}
		return rs; //return della select (ritorna la classe ResultSet)
	}
	
	public ResultSet UpdateAuto(String owner, String carPrice, String revisionDate, String startInsurancePolicy, String endInsurancePolicy, int id ) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryUpdateAuto); //Preparazione dello statement
		prst.setString(1, owner);
		prst.setString(2, carPrice);
		prst.setString(3, revisionDate);
		prst.setString(4, startInsurancePolicy);						// Binding
		prst.setString(5, endInsurancePolicy);
		prst.setInt(6, id);
		prst.execute();
		ResultSet rs = prst.getResultSet(); //Esecuzione dell'UPDATE
		if(!rs.next()) {
			rs = null;
		}
		return rs; //return dell'update (ritorna la classe ResultSet)
	}
}
