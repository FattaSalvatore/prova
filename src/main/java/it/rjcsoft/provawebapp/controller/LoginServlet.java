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

import it.rjcsoft.provawebapp.model.DBdriver;
import it.rjcsoft.provawebapp.model.User;
import it.rjcsoft.provawebapp.model.UsersDB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Pagename2= "/Home";   
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
		try {
		       	UsersDB userdb=new UsersDB(conn);
		        User utente=null;
				byte[] decodedBytes = Base64.getDecoder().decode(rs.getString("pwd"));
				String decodedString = new String(decodedBytes);
				
				if(decodedString.equals(pwd)) {
					 
			        HttpSession session = request.getSession(true);
			        session.setAttribute("user",utente);
			        disp = request.getRequestDispatcher (Pagename2);
			    }
			    
				disp.forward(request,response);
			        
		        
		 }catch(Exception e) {
			e.printStackTrace(); 
		 }finally {
			 db.closeConnection(conn);
		 }
		
	}

}
