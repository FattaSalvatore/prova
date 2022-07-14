package it.rjcsoft.provawebapp.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import it.rjcsoft.provawebapp.model.*;


/**
 * Servlet implementation class Servlet
 */

@WebServlet("/MainServlet")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private static final String Pagename= "/views/visualizza.jsp"; 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBdriver db = DBdriver.getInstance();
		Connection conn = db.openConnection();
		AutoDB auto = new AutoDB(conn);
		UsersDB user= new UsersDB(conn);
		
		
		
		try {
			ArrayList<Auto> va = auto.SelectAuto(10,0);
			request.setAttribute("Lista", va);
			
			ArrayList<User> au = user.selectAllUsers();
			request.setAttribute("PersonaLista", au);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.closeConnection(conn);
		}
		
	
		 RequestDispatcher disp = request.getRequestDispatcher (Pagename);
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