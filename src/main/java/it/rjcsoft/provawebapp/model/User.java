package it.rjcsoft.provawebapp.model;
import java.sql.Date;

public class User {
	private int id;
	private String nome;
	private String email;
	private String pwd;
	private String cognome;
	private String cf;
	private Date datanascita;
	private String ruolo;
	
	public User(int id, String email, String pwd, String ruolo, String nome, String cognome, String cf, Date datanascita) {
		super();
		this.id = id;
		this.email=email;
		this.pwd=pwd;
		this.ruolo=ruolo;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
		this.datanascita = datanascita;

	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCf() {
		return cf;
	}
	public void setCf(String cf) {
		this.cf = cf;
	}
	public Date getDatanascita() {
		return datanascita;
	}
	public void setDatanascita(Date datanascita) {
		this.datanascita = datanascita;
	}
	
}
