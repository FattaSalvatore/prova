package it.rjcsoft.provawebapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rjcsoft.provawebapp.model.DBdriver;
import it.rjcsoft.provawebapp.model.User;
import it.rjcsoft.provawebapp.model.UsersDB;
import it.rjcsoft.provawebapp.services.CheckSession;

/**
 * Servlet implementation class Inserimento
 */
@WebServlet("/Inserimento")
public class Inserimento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Pagename = "/views/form_inserimento.jsp";
	private static final String errorPage= "/views/error.jsp";
	private static final String loginPage= "/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserimento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBdriver db = DBdriver.getInstance();
		Connection conn = db.openConnection();
		UsersDB user = new UsersDB(conn);
		RequestDispatcher disp = null;
		 HttpSession session = request.getSession();
		 CheckSession cs = new CheckSession(session);
		 String ruolo = cs.CheckSession();
		 if(ruolo == null) {
			 disp = request.getRequestDispatcher (loginPage);
		 }else {
			 if(ruolo.equals("Admin")) {
				 	UsersDB userdb = new UsersDB(conn);
					
					ArrayList<User> users = null;
					try {
						users = user.selectAllUsers();
					} catch (SQLException e) {
						
						request.setAttribute("error", "Errore nel prelevare i dati degli utenti");
						disp = request.getRequestDispatcher (errorPage); 
					request.setAttribute("proprietari", users);
					}finally {
						db.closeConnection(conn);
					}
				    disp = request.getRequestDispatcher (Pagename);
				 }else {
					 
					 request.setAttribute("error", "Non seri autorizzato ad accedere");
					 disp = request.getRequestDispatcher (errorPage); 
				 }
		 }
		
		
		db.closeConnection(conn);
		disp.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
