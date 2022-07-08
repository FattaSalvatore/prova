package it.rjcsoft.provawebapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Auto {
	private Connection con;
	
	public Auto(Connection con) {
		this.con = con;
	}
	
	public boolean InsertAuto(String brand, String model, String l_Plate, String owner, String carPrice, String revisionDate, String startInsurancePolicy, String endInsurancePolicy ) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement("Insert into test1_auto (marca, modello, targa, proprietario, prezzo_auto, datarevisione, inizio_polizza, fine_polizza ) VALUES (?,?,?,?,?,?,?,?)");
		prst.setString(1, brand);
		prst.setString(2, model);
		prst.setString(3, l_Plate);
		prst.setString(4, owner);
		prst.setString(5, carPrice);
		prst.setString(6, revisionDate);
		prst.setString(7, startInsurancePolicy);
		prst.setString(8, endInsurancePolicy);
		return prst.execute();
	}
	
	public boolean DeleteAuto(String l_Plate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement("DELETE FROM test1_auto WHERE targa = ?");
		prst.setString(1, l_Plate);
		return prst.execute();
	}
	
	public ResultSet SelectAuto(String l_Plate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement("Select * from test1_auto WHERE targa = ?");
		prst.setString(1, l_Plate);
		prst.execute();
		ResultSet rs = prst.getResultSet();
		if(!rs.next()) {
			rs = null;
		}
		return rs;
	}
}
