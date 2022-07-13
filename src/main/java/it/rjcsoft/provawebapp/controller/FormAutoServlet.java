package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

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
	private static final String Pagename= "/WEB-INF/form_inserimento.jsp"; 
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
	    	request.setAttribute("Error", "Ciao");
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
		    
		    try {
		    	
				auto.InsertAuto(marca, modello, targa, Integer.parseInt(proprietario), Double.parseDouble(prezzo_auto), datarevisione, inizio_polizza, fine_polizza);
			
		    } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    RequestDispatcher disp = request.getRequestDispatcher (Pagename2);
			disp.forward(request,response);
	    }
	    
	    
	    
	
	    
	}

}
