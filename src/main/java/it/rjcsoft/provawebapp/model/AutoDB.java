package it.rjcsoft.provawebapp.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.sql.Timestamp;
import java.sql.Date;
public class AutoDB {

	

	private Connection con;
	
	private String QuerySelectAuto2 = "SELECT * FROM test1_auto WHERE id = ?";
	private String QueryInsertAuto="Insert into test1_auto (marca, modello, targa, proprietario, prezzo_auto, datarevisione, inizio_polizza, fine_polizza ) VALUES (?,?,?,?,?,?,?,?)";
	private String QueryDeleteAuto="DELETE FROM test1_auto WHERE targa = ?";
	private String QuerySelectAuto="Select ta.*, tu.cf from test1_auto ta INNER JOIN test1_users tu ON tu.id=ta.proprietario WHERE proprietario = ?";
	private String QuerySelectAutoLimitOffset="Select ta.*, tu.cf from test1_auto ta INNER JOIN test1_users tu ON tu.id=ta.proprietario LIMIT ? OFFSET ?";
	private String QueryUpdateAuto="Update test1_auto set  marca=?, modello=?, prezzo_auto=?, datarevisione=?, inizio_polizza=?, fine_polizza=? where id=?";
	
	private String id="id";
	private String marca="marca";
	private String modello="modello";
	private String targa="targa";
	private String proprietario="proprietario";
	private String prezzo_auto="prezzo_auto";
	private String datarevisione="datarevisione";
	private String inizio_polizza="inizio_polizza";
	private String fine_polizza="fine_polizza";
	private String cf="cf";
	private String iduser="iduser";
	
	
	public AutoDB(Connection con) {
		this.con = con;
	}
	
	/* Inserimento di Auto */

	public boolean InsertAuto(String brand, String model, String l_Plate, int owner, double carPrice, Date revisionDate, Timestamp startInsurancePolicy, Timestamp endInsurancePolicy ) throws SQLException {

		PreparedStatement prst = this.con.prepareStatement(QueryInsertAuto); //Preparazione dello statement
		prst.setString(1, brand);
		prst.setString(2, model);
		prst.setString(3, l_Plate);
		prst.setInt(4, owner);
		prst.setDouble(5, carPrice);
		prst.setDate(6, revisionDate);
		prst.setTimestamp(7, startInsurancePolicy);
		prst.setTimestamp(8, endInsurancePolicy);
		return prst.execute(); //esecuzione dello statement (ritorna true se andato a buon fine)
	}
	
	/* Delete di Auto */
	public boolean DeleteAuto(String l_Plate) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryDeleteAuto); //Preparazione dello statement
		prst.setString(1, l_Plate);
		return prst.execute(); //esecuzione dello statement (ritorna true se andato a buon fine)
	}
	
	/* Select di Auto */
	public ArrayList<Auto> SelectAuto(int id) throws SQLException {
		List<Auto> vp=new ArrayList<Auto>();
		try(PreparedStatement prst = this.con.prepareStatement(QuerySelectAuto))  //Preparazione dello statement
		{
		prst.setInt(1, id);
		prst.execute();
		ResultSet rs = prst.getResultSet(); // Esecuzione della SELECT
		while(rs.next()) {
			vp.add(new Auto(rs.getInt("id"),rs.getString(marca),rs.getString(cf),rs.getString(modello),rs.getString(targa),rs.getInt(proprietario),rs.getString(prezzo_auto),rs.getDate(datarevisione),rs.getTimestamp(inizio_polizza),rs.getTimestamp(fine_polizza)));
		
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<Auto>) vp;
	}
	
	/* Select di Auto */
	public ArrayList<Auto> SelectAllAuto(int limit, int offset) throws SQLException {
		List<Auto> vp=new ArrayList<Auto>();
		
		try(PreparedStatement prst = this.con.prepareStatement(QuerySelectAutoLimitOffset))  //Preparazione dello statement
		{
		prst.setInt(1, limit);
		prst.setInt(2, offset);
		prst.execute();
		ResultSet rs = prst.getResultSet(); // Esecuzione della SELECT
		while(rs.next()) {
			
			vp.add(new Auto(rs.getInt(id),rs.getString(marca),rs.getString(cf),rs.getString(modello),rs.getString(targa),rs.getInt(proprietario),rs.getString(prezzo_auto),rs.getDate(datarevisione),rs.getTimestamp(inizio_polizza),rs.getTimestamp(fine_polizza)));
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return (ArrayList<Auto>) vp;
		
	}
	
	public Boolean UpdateAuto(String brand, String model, double prezzo_auto_casted, Date datarevisione_cast, Timestamp inizio_polizza_cast, Timestamp fine_polizza_cast, int id ) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QueryUpdateAuto); //Preparazione dello statement
		prst.setString(1, brand);
		prst.setString(2, model);
		prst.setDouble(3, prezzo_auto_casted);
		prst.setDate(4, datarevisione_cast);
		prst.setTimestamp(5, inizio_polizza_cast);					
		prst.setTimestamp(6, fine_polizza_cast);
		prst.setInt(7, id);
		return prst.execute(); //return dell'update (ritorna la classe ResultSet)
	}

	public ResultSet SelectAuto2(int idAuto) throws SQLException {
		PreparedStatement prst = this.con.prepareStatement(QuerySelectAuto2); //Preparazione dello statement
		prst.setInt(1, idAuto);
		prst.execute();
		ResultSet rs = prst.getResultSet(); //Esecuzione dell'UPDATE
		if(!rs.next()) {
			rs = null;
		}
		return rs; //return dell'update (ritorna la classe ResultSet)
	}
}

