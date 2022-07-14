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

import it.rjcsoft.provawebapp.model.Auto;
import it.rjcsoft.provawebapp.model.AutoDB;
import it.rjcsoft.provawebapp.model.DBdriver;
import it.rjcsoft.provawebapp.model.User;
import it.rjcsoft.provawebapp.model.UsersDB;
import it.rjcsoft.provawebapp.services.CheckSession;


/**
 * Servlet implementation class Home
 */
@WebServlet({"/Home"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Pagename = "/views/homePage.jsp";
	private static final String loginPage = "/views/login.jsp";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher disp = null;
		 HttpSession session =request.getSession();
		 CheckSession cs= new CheckSession(session);
		 String ruolo=cs.CheckSession();
		 if(ruolo.equals("Admin") || ruolo.equals("Guest")) {
			request.setAttribute("ruolo",ruolo);
			disp=request.getRequestDispatcher(Pagename);
		 }else {
			 disp=request.getRequestDispatcher(loginPage);
		 }
		
		disp.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
