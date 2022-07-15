package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import it.rjcsoft.provawebapp.model.UsersDB;
import it.rjcsoft.provawebapp.services.CheckSession;

/**
 * Servlet implementation class FormModificaAuto
 */
@WebServlet("/FormModificaAuto")
public class FormModificaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGINPAGE = "/";
	private static final String VISUALIZZAPAGE = "/MainServlet";
	private static final String ERRORPAGE = "/views/error.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormModificaAuto() {
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
		DBdriver db = DBdriver.getInstance();
		Connection conn = db.openConnection();
		
		String error="";
		
		 RequestDispatcher disp = null;
		 HttpSession session =request.getSession();
		 CheckSession cs= new CheckSession(session);
		 String ruolo=cs.CheckSession();
		 if(ruolo == null) {
			 disp = request.getRequestDispatcher (LOGINPAGE);
		 }else {
			 if(ruolo.equals("Admin")) {
						request.setAttribute("ruolo",ruolo);
						disp=request.getRequestDispatcher(VISUALIZZAPAGE);
				 
					    AutoDB auto = new AutoDB(conn);
					    UsersDB userdb = new UsersDB(conn);
					    String marca=request.getParameter("marca");
					    String id = request.getParameter("id");
					    String modello=request.getParameter("modello");
					    String prezzo_auto=request.getParameter("prezzo");
					    String datarevisione=request.getParameter("revisione");
					    String inizio_polizza=request.getParameter("i_polizza");
					    String fine_polizza=request.getParameter("f_polizza");
					    ResultSet rs=null;
					    if(marca==null || marca.isEmpty() || 
				 	       modello==null || modello.isEmpty() ||
				 	       prezzo_auto==null || prezzo_auto.isEmpty() ||
				 	       id==null || id.isEmpty() ||
				 	       datarevisione==null || datarevisione.isEmpty() ||
				 	       inizio_polizza==null || inizio_polizza.isEmpty() ||
				 	       fine_polizza==null || fine_polizza.isEmpty()){
					    	
					    	disp = request.getRequestDispatcher (ERRORPAGE);
					    	request.setAttribute("Error", "Errore, dati inseriti incorretti o mancanti");
							disp.forward(request,response);
					    }else {
					    	
					    	int idAuto = Integer.parseInt(id);
					    	marca=marca.trim();
						    modello=modello.trim();
						    prezzo_auto=prezzo_auto.trim();
						    datarevisione=datarevisione.trim();
						    inizio_polizza=inizio_polizza.trim();
						    fine_polizza=fine_polizza.trim();
						    Date datarevisione_cast=null;
						    
						    String errori=null;
						    
						    int proprietario_casted=0;
						   
						    double prezzo_auto_casted=0;
						    
						    Timestamp inizio_polizza_cast=null;
						    Timestamp fine_polizza_cast=null;
						    try {
						    	
						        datarevisione_cast=StringToDate(datarevisione);
						    } catch (ParseException e) {
								// TODO Auto-generated catch block
						    	errori+="Formato data revisione errato deve essere: yyyy-MM-dd \n";
						    	
							}  
						    
						    try {
						    	
						    	inizio_polizza=inizio_polizza+" 00:00:00.0";
						    	inizio_polizza_cast=StringToTimestamp(inizio_polizza);
						    } catch (ParseException e) {
								// TODO Auto-generated catch block
						    	errori+="Formato data inizio polizza errato deve essere: yyyy-MM-dd \n";
							}
						    
						    try {
						    	fine_polizza=fine_polizza+" 23:59:59.999";
						    	fine_polizza_cast=StringToTimestamp(fine_polizza);
						    } catch (ParseException e) {
								// TODO Auto-generated catch block
						    	errori+="Formato data fine polizza errato deve essere: yyyy-MM-dd \n";
							}
						    
						    if(inizio_polizza_cast.before(fine_polizza_cast)) {
						    	
						    	try {
									rs=auto.SelectAuto2(idAuto);
								} catch (SQLException e1) {
									errori+="Auto non esistente \n";
								}
						    	
							    
							    try{
							    	prezzo_auto_casted=Double.parseDouble(prezzo_auto);
							    }
							    catch(NumberFormatException e){
							    	errori+="Numero non double \n";
							    }
							    
							    try {
							    			
									auto.UpdateAuto(marca, modello, prezzo_auto_casted,  datarevisione_cast, inizio_polizza_cast, fine_polizza_cast, rs.getInt("id"));

							    } catch (SQLException e) {
									// TODO Auto-generated catch block
							    	errori+="Dati non insriti \n";
								}
							    
							    if(errori!=null) {
							    	request.setAttribute("Error", errori);
							    	disp = request.getRequestDispatcher (ERRORPAGE);
									
							    }else {
							    	disp = request.getRequestDispatcher (VISUALIZZAPAGE);
							    }
						    }else {
						    	errori+="La data di fine polizza è prima di inizio polizza \n";
						    	request.setAttribute("Error", errori);
						    	disp = request.getRequestDispatcher (ERRORPAGE);
						    }
						  
						    
						    db.closeConnection(conn);
							disp.forward(request,response);
					    }
				}else{
					error="Non sei autorizzato ad accedere";
		       		request.setAttribute("Error", error);
			    	disp = request.getRequestDispatcher (ERRORPAGE);
			    	disp.forward(request, response);
				}
		 }
	}
	
	private Date StringToDate(String ToBeConverted)throws  ParseException{
		java.util.Date date_casted=null; 
		Date dateSql=null;
		
			
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		date_casted=sdf.parse(ToBeConverted);
		dateSql=new Date(date_casted.getTime());
		
		return dateSql;
		
	}
	
	private Timestamp StringToTimestamp(String ToBeConverted)throws ParseException {
		
		Calendar parsedDate=Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		parsedDate.setTime(sdf.parse(ToBeConverted));
			
		
	    Timestamp timestamp_casted = new java.sql.Timestamp(parsedDate.getTimeInMillis());
	    return timestamp_casted;
	}

}