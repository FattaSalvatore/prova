package it.rjcsoft.provawebapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.rjcsoft.provawebapp.services.CheckSession;

/**
 * Servlet implementation class ModificaAuto
 */
@WebServlet("/ModificaAuto")
public class ModificaAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FORMMODIFICA = "./views/modifica.jsp";
	private static final String MARCA = "marca";
	private static final String MODELLO = "modello";
	private static final String PREZZO = "prezzo";
	private static final String DATAREVISIONE = "datarevisione";
	private static final String I_POLIZZA = "i_polizza";
	private static final String F_POLIZZA = "f_polizza";
	private static final String ID = "id";
	private static final String LOGIN = "./views/login.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = null;
		HttpSession session =request.getSession();
		CheckSession cs= new CheckSession(session);
		String ruolo=cs.CheckSession();
		 if(ruolo == null) {
			 disp = request.getRequestDispatcher (LOGIN);
		 }else {
			String marca = request.getParameter("marca");
			String modello = request.getParameter("modello");
			String prezzo =  request.getParameter("prezzo");
			String datarevisione =  request.getParameter("datarevisione");
			String i_polizza = request.getParameter("i_polizza");
			String f_polizza =  request.getParameter("f_polizza");
			String id =  request.getParameter("id");
			i_polizza = i_polizza.substring(0, 10);
			f_polizza = f_polizza.substring(0, 10);
			
			disp = request.getRequestDispatcher(FORMMODIFICA);
			request.setAttribute(MARCA, marca);
			request.setAttribute(MODELLO, modello);
			request.setAttribute(PREZZO, prezzo);
			request.setAttribute(DATAREVISIONE, datarevisione);
			request.setAttribute(I_POLIZZA, i_polizza);
			request.setAttribute(F_POLIZZA, f_polizza);
			request.setAttribute(ID, id);
		 }
		 disp.forward(request, response);
	}

}
