package com.simplilearn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simplilearn.dao.UsersDao;
import com.simplilearn.model.Users;

@Controller
public class UsersController {
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request, Model model) {
		
		String uName = request.getParameter("uName");
		String uAge  = request.getParameter("uAge");
		String uPass = request.getParameter("uPass");
		String message;
		
		if(uName.isEmpty() || uAge.isEmpty() || uPass.isEmpty()) {
			message = "Error - Enter all parameters";
			model.addAttribute("message", message);
		}
		else {
			Users user = new Users (0,uName,uAge,uPass);
			UsersDao usersDao = new UsersDao();
			usersDao.saveOrUpdateUsers(user);
			
			message = "Success - New user Id# created - " + user.getId();
			model.addAttribute("message", message);
		}
		return "home";			
	}
	
	@SuppressWarnings("null")
	@RequestMapping("/readUser")
	public String readUser(HttpServletRequest request, Model model) {
		
		String message;
		if(request.getParameter("uId").isEmpty()) {
			message = "Error - Enter parameter";
			model.addAttribute("message", message);
			return "home";
		}
		else {
			
			Integer uId = Integer.parseUnsignedInt((String) request.getParameter("uId"));

			System.out.print("uId " + uId);
			UsersDao usersDao = new UsersDao();
			Users user = usersDao.readUserById(uId);
			
			HttpSession session = request.getSession();
			session.setAttribute("uId", user.getId());
			session.setAttribute("uAge", user.getuAge());
			session.setAttribute("uName", user.getuName());
			session.setAttribute("uPass", user.getuPass());
			
			message = "Success - Record Found";
			model.addAttribute("message", message);
			
			return "retrievedUser"; 
		}
	}	
	
	@RequestMapping("/updateUser")
	public String updateUser(HttpServletRequest request, Model model) {
		
		System.out.println( "uid " + request.getParameter("uId"));
		System.out.println( "uage " + request.getParameter("uAge"));
		System.out.println( "uname " + request.getParameter("uName"));
		System.out.println( "upass " + request.getParameter("uPass"));
		
		Integer uId = Integer.parseUnsignedInt((String) request.getParameter("uId"));
		String uName = request.getParameter("uName");
		String uAge  = request.getParameter("uAge");
		String uPass = request.getParameter("uPass");
		String message;
		
		if(uId == null || uName.isEmpty() || uAge.isEmpty() || uPass.isEmpty()) {
			message = "Error - Enter all parameters";
			model.addAttribute("message", message);
		}
		else {
			Users user = new Users (uId,uName,uAge,uPass);
			System.out.println(user.toString());
			UsersDao usersDao = new UsersDao();
			usersDao.saveOrUpdateUsers(user);
			
			message = "Success - Record updated";
			model.addAttribute("message", message);
		}
		return "home";			
	}

}
