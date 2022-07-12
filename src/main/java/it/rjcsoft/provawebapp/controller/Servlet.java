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

import it.rjcsoft.provawebapp.model.Auto;
import it.rjcsoft.provawebapp.model.AutoDB;
import it.rjcsoft.provawebapp.model.DBdriver;

/**
 * Servlet implementation class Servlet
 */

@WebServlet("/MainServlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

        String Pagename = null;
        if(Pagename==null) {
            Pagename="FILEJSP";
            Pagename= "/WEB-INF/"+Pagename+".jsp";

            try {
                ArrayList<Auto> va = auto.SelectAuto(10,1);
                request.setAttribute("Lista", va);
            } catch (SQLException e) {

                e.printStackTrace();
            }

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