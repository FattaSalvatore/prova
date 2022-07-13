package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.rjcsoft.provawebapp.model.AutoDB;
import it.rjcsoft.provawebapp.model.DBdriver;
import it.rjcsoft.provawebapp.model.User;
import it.rjcsoft.provawebapp.model.UsersDB;


/**
 * Servlet implementation class FormAutoServlet
 */
@WebServlet("/FormAutoServlet")
public class FormAutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String Pagename= "/WEB-INF/error.jsp"; 
	private static final String Pagename2= "/Servlet";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormAutoServlet() {
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
	    AutoDB auto = new AutoDB(conn);
	    
	    String marca=request.getParameter("marca");
	    String modello=request.getParameter("modello");
	    String targa=request.getParameter("targa");
	    String proprietario=request.getParameter("proprietario");
	    String prezzo_auto=request.getParameter("prezzo");
	    String datarevisione=request.getParameter("revisione");
	    String inizio_polizza=request.getParameter("i_polizza");
	    String fine_polizza=request.getParameter("f_polizza");
	   
	    if(marca==null || marca.isEmpty() || 
 	       modello==null || modello.isEmpty() ||
 	       targa==null || targa.isEmpty() ||
 	       proprietario==null || proprietario.isEmpty() ||
 	       prezzo_auto==null || prezzo_auto.isEmpty() ||
 	       datarevisione==null || datarevisione.isEmpty() ||
 	       inizio_polizza==null || inizio_polizza.isEmpty() ||
 	       fine_polizza==null || fine_polizza.isEmpty()) {

			UsersDB user = new UsersDB(conn);
			
			ArrayList<User> users = user.SelectUserLimitOffset(10,1);
			request.setAttribute("proprietari", users);
	    	
	    	RequestDispatcher disp = request.getRequestDispatcher (Pagename);
	    	request.setAttribute("Error", "Errore nell'inserimento dati");
			disp.forward(request,response);
	    }else {
	    	
	    	marca=marca.trim();
		    modello=modello.trim();
		    targa=targa.trim();
		    proprietario=proprietario.trim();
		    prezzo_auto=prezzo_auto.trim();
		    datarevisione=datarevisione.trim();
		    inizio_polizza=inizio_polizza.trim();
		    fine_polizza=fine_polizza.trim();
		    Date datarevisione_cast=null;
		    RequestDispatcher disp=null;
		   
		    boolean problem=false;
		   
		    int proprietario_casted=0;
		   
		    double prezzo_auto_casted=0;
		    
		    Timestamp inizio_polizza_cast=null;
		    Timestamp fine_polizza_cast=null;
		    try {
		    	
		        datarevisione_cast=StringToDate(datarevisione);
		    } catch (ParseException e) {
				// TODO Auto-generated catch block
		    	request.setAttribute("Error", "Formato data revisione errato deve essere: yyyy-MM-dd");
		    	problem=true;
			}  
		    
		    
		    
		    try {
		    	
		    	inizio_polizza=inizio_polizza+" 00:00:00.0";
		    	inizio_polizza_cast=StringToTimestamp(inizio_polizza);
		    } catch (ParseException e) {
				// TODO Auto-generated catch block
		    	problem=true;
			}
		    try {
		    	fine_polizza=fine_polizza+" 23:59:59.999";
		    	fine_polizza_cast=StringToTimestamp(fine_polizza);
		    } catch (ParseException e) {
				// TODO Auto-generated catch block

		    	problem=true;
			}
		    
		  
		    try {
		    	 proprietario_casted= Integer.parseInt(proprietario);
		    } catch (NumberFormatException nfe) {

		    	problem=true;
		    }
		    
		    
		    try{
		    	prezzo_auto_casted=Double.parseDouble(prezzo_auto);
		    }
		    catch(NumberFormatException e){
		    	problem=true;
		    }
		    
		    try {
		    			
				auto.InsertAuto(marca, modello, targa,proprietario_casted ,prezzo_auto_casted,  datarevisione_cast, inizio_polizza_cast, fine_polizza_cast);

			
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				problem=true;
			}
		    if(problem==true) {
		    	request.setAttribute("Error", "Errore nell'inserimento dei dati");
		    	disp = request.getRequestDispatcher (Pagename);
				
		    }else {
		    	disp = request.getRequestDispatcher (Pagename2);
		    }
		    
			disp.forward(request,response);
	    }
	    
	       
	}
	
	private Date StringToDate(String ToBeConverted)throws  ParseException{
		System.out.println("FUNZIONE DATE");
		java.util.Date date_casted=null; 
		Date dateSql=null;
		
			
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		date_casted=sdf.parse(ToBeConverted);
		dateSql=new Date(date_casted.getTime());
		
		return dateSql;
		
	}
	
	private Timestamp StringToTimestamp(String ToBeConverted)throws ParseException {
		System.out.println("FUNZIONE TIMESTAMP");
		
		Calendar parsedDate=Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		parsedDate.setTime(sdf.parse(ToBeConverted));
			
		
	    Timestamp timestamp_casted = new java.sql.Timestamp(parsedDate.getTimeInMillis());
	    return timestamp_casted;
	}
}
