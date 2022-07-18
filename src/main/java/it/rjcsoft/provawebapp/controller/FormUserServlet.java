package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rjcsoft.provawebapp.model.AutoDB;
import it.rjcsoft.provawebapp.model.DBdriver;
import it.rjcsoft.provawebapp.model.User;
import it.rjcsoft.provawebapp.model.UsersDB;
import it.rjcsoft.provawebapp.services.CheckSession;


/**
 * Servlet implementation class FormAutoServlet
 */
@WebServlet("/FormUserServlet")
public class FormUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String errorPage= "/views/error.jsp"; 
	private static final String homePage= "/Servlet";
	private static final String loginPage= "/";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		DBdriver db = DBdriver.getInstance();
		Connection conn = db.openConnection();
		
		String error="";
		
		 RequestDispatcher disp = null;
		 HttpSession session =request.getSession();
		 CheckSession cs= new CheckSession(session);
		 String ruolo=cs.CheckSession();
		 if(ruolo == null) {
			 disp = request.getRequestDispatcher (loginPage);
		 }else {
			 if(ruolo.equals("Admin")) {
						request.setAttribute("ruolo",ruolo);
						UsersDB user = new UsersDB(conn);
					    
					    String nome=request.getParameter("nome");
					    String cognome=request.getParameter("cognome");
					    String cf=request.getParameter("cf");
					    String datanascita=request.getParameter("datanascita");
					    String ruoloInput=request.getParameter("ruoloInput");
					    String email=request.getParameter("email");
					    String password=request.getParameter("password");
					    int ruolo_cast=0;
					    if(nome==null || nome.isEmpty() || 
					       cognome==null || cognome.isEmpty() ||
					       cf==null || cf.isEmpty() ||
					       datanascita==null || datanascita.isEmpty() ||
					       ruoloInput==null || ruoloInput.isEmpty() ||
					       email==null || email.isEmpty() ||
					       password==null || password.isEmpty()){
							System.out.println(nome);
							System.out.println(cognome);
							System.out.println(cf);
							System.out.println(datanascita);
							System.out.println(ruoloInput);
							System.out.println(email);
							System.out.println(password);
					    	disp = request.getRequestDispatcher (errorPage);
					    	request.setAttribute("Error", "Errore, dati inseriti incorretti o mancanti");
							
					    }else {
					    	
						    	nome=nome.trim();
						    	cognome=cognome.trim();
						    	cf=cf.trim();
						    	datanascita=datanascita.trim();
						    	ruoloInput=ruoloInput.trim();
						    	email=email.trim();
						    	password=password.trim();
							    
						    	Date datanascita_cast=null;
							    
							    try {
							    	
							    	datanascita_cast=StringToDate(datanascita);
							    } catch (ParseException e) {
									// TODO Auto-generated catch block
							    	error+="Formato data revisione errato deve essere: yyyy-MM-dd \n";
							    	
								}  
							    
							  
							    try {
							    	ruolo_cast= Integer.parseInt(ruoloInput);
							    } catch (NumberFormatException nfe) {
							    	error+="Numero non intero \n";
							    }

							  
								String encodedPwd = Base64.getEncoder().encodeToString(password.getBytes());
							    try {
							    			
									user.InsertUser2(email,encodedPwd,nome, cognome, cf,datanascita_cast,ruolo_cast);
	
							    } catch (SQLException e) {
									e.printStackTrace();
							    	error+="Dati non inseriti \n";
								}
							    
							   
							    if(!error.equals("")) {
							    	request.setAttribute("Error", error);
							    	disp = request.getRequestDispatcher (errorPage);
									
							    }else{
							    	
							    	disp = request.getRequestDispatcher (homePage);
							    	
							    }
						  
							    db.closeConnection(conn);
							
					    }
				}else{
					error="Non sei autorizzato ad accedere";
		       		request.setAttribute("Error", error);
			    	disp = request.getRequestDispatcher (errorPage);
			    	
				}
			 
		 }
		 disp.forward(request,response);
	}
	
	private Date StringToDate(String ToBeConverted)throws  ParseException{
		java.util.Date date_casted=null; 
		Date dateSql=null;
		
			
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		date_casted=sdf.parse(ToBeConverted);
		dateSql=new Date(date_casted.getTime());
		
		return dateSql;
		
	}
	
	
}
