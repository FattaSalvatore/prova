package it.rjcsoft.provawebapp.services;

import javax.servlet.http.HttpSession;

import it.rjcsoft.provawebapp.model.User;

public class CheckSession {

	public String CheckSession(HttpSession sessione) {
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
