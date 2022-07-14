package it.rjcsoft.provawebapp.services;

import javax.servlet.http.HttpSession;

import it.rjcsoft.provawebapp.model.User;

public class CheckSession {
	private HttpSession sessione;
	
	
	public CheckSession(HttpSession sessione) {
		super();
		this.sessione = sessione;
	}


	public final String CheckSession() {
		String check = null;
		if(sessione.getId() == null) {
			return check;
		}else {
			try {
				User u = (User) sessione.getAttribute("user");
				if(u.getRuolo().equals("Admin")) {
					check = "Admin";
				}else if(u.getRuolo().equals("Guest")) {
					check = "Guest";
				}
			} catch (Exception e) {
			}
		}
		return check;
	}
}
