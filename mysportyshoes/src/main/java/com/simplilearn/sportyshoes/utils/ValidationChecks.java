package com.simplilearn.sportyshoes.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ValidationChecks {

// Check if user is logged in
	public static boolean isUserLoggedIn(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute("sessUser") == null || session.getAttribute("sessUser").toString().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

// Check if admin user is logged in
	public static boolean isAdminUserLoggedIn(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if ((session.getAttribute("sessUser") == null || session.getAttribute("sessUser").toString().isEmpty())
				|| (session.getAttribute("sessPass") == null || session.getAttribute("sessPass").toString().isEmpty())
				|| (session.getAttribute("sessAdmin") == null || session.getAttribute("sessAdmin").toString().isEmpty())
				|| (session.getAttribute("sessAdminPass") == null
				|| session.getAttribute("sessAdminPass").toString().isEmpty())) {
			return false;
		} else {
			return true;
		}
	}

// check payment details provided
	public static boolean isPayDetailsProvided(String cardType, String holderName, int cardNo, String expiryDate,
			int securityNo) {
		if (cardType.isEmpty() || holderName.isEmpty() || cardNo == 0 || expiryDate.isEmpty() || securityNo == 0) {
			return false;
		} else {
			return true;
		}
	}
}
