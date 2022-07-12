package it.rjcsoft.provawebapp.model;

import java.sql.Date;

public class Auto {
	private int id;
	private String marca;
	private String modello;
	private String targa;
	private int proprietario;
	private String prezzo_auto;
	private Date datarevisione;
	
	
	
	public Auto(int id, String marca, String modello, String targa, int proprietario, String prezzo_auto,
			Date datarevisione) {
		super();
		this.id = id;
		this.marca = marca;
		this.modello = modello;
		this.targa = targa;
		this.proprietario = proprietario;
		this.prezzo_auto = prezzo_auto;
		this.datarevisione = datarevisione;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModello() {
		return modello;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public String getTarga() {
		return targa;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public int getProprietario() {
		return proprietario;
	}
	public void setProprietario(int proprietario) {
		this.proprietario = proprietario;
	}
	public String getPrezzo_auto() {
		return prezzo_auto;
	}
	public void setPrezzo_auto(String prezzo_auto) {
		this.prezzo_auto = prezzo_auto;
	}
	public Date getDatarevisione() {
		return datarevisione;
	}
	public void setDatarevisione(Date datarevisione) {
		this.datarevisione = datarevisione;
	}

	
	
	
}
