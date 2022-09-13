
package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
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
	private static final String Pagename= "/views/login.jsp"; 
	
	private static final String EMAIL = "email";
	private static final String PWD = "pwd";
	private static final String ID = "id";
	private static final String NOME = "nome";
	private static final String COGNOME = "cognome";
	private static final String CF = "cf";
	private static final String DATANASCITA = "datanascita";
	private static final String RUOLO = "ruolo";
	private static final String FK_IDUSER = "iduser";
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=null;
		String email=request.getParameter(EMAIL);
		String pwd=request.getParameter(PWD);
		DBdriver db = DBdriver.getInstance();
		Connection conn = db.openConnection();
		RequestDispatcher disp=null;
        User utente=null;
        UsersDB user= new UsersDB(conn);
        CredenzialiDB credenziali = new CredenzialiDB(conn);
        ResultSet rs=null;
		String error="";
		session=request.getSession();  
        session.invalidate();
		if(email!=null && !email.isEmpty() || pwd!=null && !pwd.isEmpty()) {
		
			try {
				 	ResultSet rsCredenziali = credenziali.selectCredenziali(email);
					if(rsCredenziali != null) {
					 	rs = user.SelectUser(rsCredenziali.getInt(FK_IDUSER));
						rsCredenziali = null;
				       	
						if(rs!=null) {
							
							String dbinput = rs.getString(PWD);
							String encodedString = Base64.getEncoder().encodeToString(pwd.getBytes());
							if(dbinput.equals(encodedString)) {
								
	
								utente = new User(rs.getInt(ID),rs.getString(EMAIL),rs.getString(PWD),rs.getString(NOME),rs.getString(COGNOME),rs.getString(CF),rs.getDate(DATANASCITA),rs.getString(RUOLO)); 
						        session = request.getSession(true);
						        session.setAttribute("user",utente);
						        disp = request.getRequestDispatcher (Pagename2);
						    
							}else {
								error="Password non corretta";
					       		request.setAttribute("Error", error);
						    	disp = request.getRequestDispatcher (Pagename);
							}
				       	}else {
				       		error="Account inesistente";
				       		request.setAttribute("Error", error);
					    	disp = request.getRequestDispatcher (Pagename);
				       	}
					}else {
						error="Account inesistente";
			       		request.setAttribute("Error", error);
				    	disp = request.getRequestDispatcher (Pagename);
					}
					
				        
			        
			 }catch(Exception e) {
			    	disp = request.getRequestDispatcher (Pagename);
				e.printStackTrace(); 
			 }finally {
				 db.closeConnection(conn);
			 }
		}else {
			error="Credenziali non inserite";
			request.setAttribute("Error", error);
	    	disp = request.getRequestDispatcher (Pagename);
			
		}
		db.closeConnection(conn);
		disp.forward(request,response);
		
	}

}
