
package it.rjcsoft.provawebapp.model;

import java.sql.*;

public class DBdriver {
	private static DBdriver dbdriver;
	private String connString;

	private DBdriver() {
		DBdriver.dbdriver = null;
		this.connString = null;

	}

	public static synchronized DBdriver getInstance() {
		if (dbdriver == null) {
			dbdriver = new DBdriver();
		}
		return dbdriver;

	}

	public String getConnString() {
		return connString;
	}

	public java.sql.Connection openConnection() {
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:postgresql://sviluppo.rjcsoft.it/test", "test_user","!$Av2kkm#KCnJFen2$57rjc");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(java.sql.Connection conn) {
		try {
			conn.close();
		} catch (Exception ex) {
		}
	}
}
