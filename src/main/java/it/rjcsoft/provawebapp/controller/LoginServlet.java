package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rjcsoft.provawebapp.model.CredenzialiDB;
import it.rjcsoft.provawebapp.model.DBdriver;
import it.rjcsoft.provawebapp.model.User;
import it.rjcsoft.provawebapp.model.UsersDB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Pagename2= "/Home";
	private static final String Pagename= "/views/error.jsp"; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		DBdriver db = DBdriver.getInstance();
		Connection conn = db.openConnection();
		RequestDispatcher disp=null;
        User utente=null;
        CredenzialiDB credenziali= new CredenzialiDB(conn);
        ResultSet rs=null;
		String error="";
		if(email==null || email.isEmpty() || pwd==null || pwd.isEmpty()) {
		
			try {
				 	
					rs= credenziali.SelectCredenziali(email);
			       	if(rs!=null) {
						
						String dbinput = rs.getString("pwd");
						String encodedString = Base64.getEncoder().encodeToString(pwd.getBytes());
						if(dbinput.equals(encodedString)) {
							
							utente = new User(rs.getInt("id"),rs.getString("email"),rs.getString("pwd"),rs.getString("nome"),rs.getString("cognome"),rs.getString("cf"),rs.getDate("datanascita"),rs.getString("ruolo")); 
					        HttpSession session = request.getSession(true);
					        session.setAttribute("user",utente);
					        disp = request.getRequestDispatcher (Pagename2);
					    
						}else {
							error="Account inesistentePassword non corretta";
				       		request.setAttribute("Error", error);
					    	disp = request.getRequestDispatcher (Pagename);
						}
			       	}else {
			       		error="Account inesistente";
			       		request.setAttribute("Error", error);
				    	disp = request.getRequestDispatcher (Pagename);
			       	}
					
					disp.forward(request,response);
				        
			        
			 }catch(Exception e) {
				e.printStackTrace(); 
			 }finally {
				 db.closeConnection(conn);
			 }
		}else {
			db.closeConnection(conn);
		}
		
		
	}

}
