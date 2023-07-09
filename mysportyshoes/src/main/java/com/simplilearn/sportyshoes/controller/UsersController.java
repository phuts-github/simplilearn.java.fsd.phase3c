package com.simplilearn.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.OrderTransItemHist;
import com.simplilearn.sportyshoes.models.Orders;
import com.simplilearn.sportyshoes.models.Products;
import com.simplilearn.sportyshoes.models.Users;
import com.simplilearn.sportyshoes.repository.OrderTransItemHistRepository;
import com.simplilearn.sportyshoes.repository.OrdersRepository;
import com.simplilearn.sportyshoes.repository.ProductsRepository;
import com.simplilearn.sportyshoes.repository.UsersRepository;
import com.simplilearn.sportyshoes.utils.ValidationChecks;

//@RestController
@Controller
public class UsersController {
	UsersController() {
	}

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	OrderTransItemHistRepository orderTransItemHistRepository;

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		ModelAndView mv = new ModelAndView();
	 	mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping("/userAddUpdate")
	public ModelAndView userAddUpdate(HttpServletRequest request, @RequestParam int id, @RequestParam String email,
			@RequestParam String name, @RequestParam String pass, @RequestParam String admin,
			@RequestParam String adminPass, @RequestParam String address) {

		ModelAndView mv = new ModelAndView();

	 	if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (email == "" || name == "" || pass == "" || admin == "" || adminPass == "" || address == "") {
				mv.addObject("message", "All parameters required");
				mv.setViewName("user-add.jsp");
				return mv;
			} else {
	 			Users users = new Users();
				users.setId(id);
				users.setEmail(email);
				users.setName(name);
				users.setPass(pass);
				users.setAdmin(admin);
				users.setAdminPass(adminPass);
				users.setAddress(address);
				usersRepository.saveAndFlush(users);
				mv.addObject("message", "Added/Updated ID " + users.getId());
				mv.setViewName("user-add.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/userRegister")
	public ModelAndView userRegister(@RequestParam int id, @RequestParam String email, @RequestParam String name,
			@RequestParam String pass, @RequestParam String address) {

		ModelAndView mv = new ModelAndView();

		if (email == "" || name == "" || pass == "" || address == "") {
			mv.addObject("message", "All parameters required");
			mv.setViewName("user-add.jsp");
			return mv;
		} else {
			Users entry = usersRepository.findByEmail(email);

			if (!(entry == null)) {
				mv.addObject("message", "Email already exists");
				mv.setViewName("user-login.jsp");
				return mv;
			} else {
				Users users = new Users();
				users.setId(0);
				users.setEmail(email);
				users.setName(name);
				users.setPass(pass);
				users.setAdmin("");
				users.setAdminPass("");
				users.setAddress(address);
				usersRepository.saveAndFlush(users);
				mv.addObject("message", "Added/Updated");
				mv.setViewName("user-login.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/userList")
	public ModelAndView userList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		List<Users> entries = usersRepository.findAll();
		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (entries.isEmpty()) {
				mv.addObject("message", "No Users Available");
				mv.setViewName("user-add.jsp");
				return mv;
			} else {
				mv.addObject("entries", entries);
				mv.setViewName("user-add.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/userById")
	public ModelAndView userById(HttpServletRequest request, @RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("user-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				List<Users> entry = new ArrayList<Users>();
				Users entry0 = usersRepository.findById(uId).orElse(new Users());
				entry.add(entry0);

				if (entry0 == null) {
					mv.addObject("message", "No Users Found");
					mv.setViewName("user-add.jsp");
					return mv;
				} else {
					mv.addObject("entry", entry);
					mv.setViewName("user-add.jsp");
					return mv;
				}
			}
		}
	}

	@RequestMapping("/userDeleteById")
	public ModelAndView userDeleteById(HttpServletRequest request, @RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("user-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				usersRepository.deleteById(uId);
				mv.addObject("message", "Deleted");
				mv.setViewName("user-add.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/userByEmail")
	public ModelAndView userByEmail(HttpServletRequest request, @RequestParam String email) {

		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (email == "") {
				mv.addObject("message", "Email ID required");
				mv.setViewName("user-add.jsp");
				return mv;
			} else {
				List<Users> entry = new ArrayList<Users>();
				Users entry0 = usersRepository.findByEmail(email);
				entry.add(entry0);

				if (entry0 == null) {
					mv.addObject("message", "No User Found");
					mv.setViewName("user-add.jsp");
					return mv;
				} else {
					mv.addObject("entry", entry);
					mv.setViewName("user-add.jsp");
					return mv;
				}
			}
		}
	}

	@RequestMapping("/userLogin")
	public ModelAndView userLogin(HttpServletRequest request, @RequestParam String email, @RequestParam String pass) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (email == "" || pass == "") {
			mv.addObject("message", "All login parameters required");
			mv.setViewName("user-login.jsp");
			return mv;
		} else {
			Users entry = usersRepository.findByEmailAndPass(email, pass);

			if (entry == null) {
				mv.addObject("message", "Invalid login parameters");
				mv.setViewName("user-login.jsp");
				return mv;
			} else {
				session.setAttribute("sessUser", entry.getEmail());

				List<Products> entries = productsRepository.findAll();

				if (entries.isEmpty()) {
					mv.addObject("message", "Shopping is offline, try again later");
					mv.setViewName("shop-list.jsp");
					return mv;
				} else {
					mv.addObject("entries", entries);
					mv.setViewName("shop-list.jsp");
					return mv;
				}
			}
		}
	}

	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request, @RequestParam String email, @RequestParam String pass,
			@RequestParam String admin, @RequestParam String adminpass) {

		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (email == "" || pass == "" || admin == "" || adminpass == "") {
			mv.addObject("message", "All login parameters required");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			Users entry = usersRepository.findByEmailAndPassAndAdminAndAdminPass(email, pass, admin, adminpass);

			if (entry == null) {
				mv.addObject("message", "Invalid login parameters");
				mv.setViewName("user-login-admin.jsp");
				return mv;
			} else {
				session.setAttribute("sessUser", entry.getEmail());
				session.setAttribute("sessPass", entry.getPass());
				session.setAttribute("sessAdmin", entry.getAdmin());
				session.setAttribute("sessAdminPass", entry.getAdminPass());

				mv.addObject("message", "Ready for admin");
				mv.addObject("entry", entry);
				mv.setViewName("admin-menu-list.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/userRegisterAdmin")
	public ModelAndView userRegisterAdmin(@RequestParam int id, @RequestParam String email, @RequestParam String name,
			@RequestParam String pass, @RequestParam String admin, @RequestParam String adminPass,
			@RequestParam String address) {

		ModelAndView mv = new ModelAndView();

		if (email == "" || name == "" || pass == "" || admin == "" || adminPass == "" || address == "") {
			mv.addObject("message", "All parameters required");
			mv.setViewName("user-add-admin.jsp");
			return mv;
		} else {

			if (!admin.contentEquals("admins")) {
				mv.addObject("message", "Invalid administrator code");
				mv.setViewName("user-add-admin.jsp");
				return mv;
			} else {
				Users entry = usersRepository.findByEmail(email);

				if (!(entry == null)) {
					mv.addObject("message", "Email already exists");
					mv.setViewName("user-add-admin.jspp");
					return mv;
				} else {
					Users users = new Users();
					users.setId(0);
					users.setEmail(email);
					users.setName(name);
					users.setPass(pass);
					users.setAdmin(admin);
					users.setAdminPass(adminPass);
					users.setAddress(address);
					usersRepository.save(users);
					usersRepository.flush();
					mv.addObject("message", "Added/Updated");
					mv.setViewName("user-login-admin.jsp");
					return mv;
				}
			}
		}
	}

	@RequestMapping("/userPassUpdate")
	public ModelAndView userPassUpdate(HttpServletRequest request, @RequestParam String oldPass,
			@RequestParam String newPass, @RequestParam String confNewPass) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login.jsp");
			return mv;
		} else {
			if (oldPass == "" || newPass == "" || confNewPass == "") {
				mv.addObject("message", "All parameters required");
				mv.setViewName("user-profile.jsp");
				return mv;
			} else {
				String email = (String) session.getAttribute("sessUser");

				Users user = new Users();
				user = usersRepository.findByEmail(email);

				if (user == null) {
					mv.addObject("message", "User not found");
					mv.setViewName("user-profile.jsp");
					return mv;
				} else {

					String currPass = (String) user.getPass();

					if (currPass.contentEquals(oldPass) && newPass.contentEquals(confNewPass)) {
						user.setPass(newPass);
						usersRepository.saveAndFlush(user);
						mv.addObject("message", "Updated");
						mv.addObject("userEntry", user);
						mv.setViewName("user-profile.jsp");
						return mv;
					} else {
						mv.addObject("message", "Invalid password parameters");
						mv.addObject("userEntry", user);
						mv.setViewName("user-profile.jsp");
						return mv;
					}

				}
			}
		}
	}

	@RequestMapping("/userGetProfile")
	public ModelAndView userGetProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login.jsp");
			return mv;
		} else {
			String email = (String) session.getAttribute("sessUser");

			Users userEntry = new Users();
			userEntry = usersRepository.findByEmail(email);

			if (userEntry == null) {
				mv.addObject("message", "User not found");
				mv.setViewName("user-profile.jsp");
				return mv;
			} else {
				
				List<Orders> userMyOrders = new ArrayList<Orders>();
				userMyOrders = ordersRepository.findOrdersUsingEmail(email);				

				mv.addObject("userMyOrders", userMyOrders);
				mv.addObject("userEntry", userEntry);
				mv.setViewName("user-profile.jsp");
				return mv;
			}
		}
	}
	
	@RequestMapping("/userOrderViewDetailsById")
	public ModelAndView userOrderViewDetailsById(HttpServletRequest request, @RequestParam int id) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		
		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login.jsp");
			return mv;
		} else {
			String email = (String) session.getAttribute("sessUser");

			Users userEntry = new Users();
			userEntry = usersRepository.findByEmail(email);

			if (userEntry == null) {
				mv.addObject("message", "User not found");
				mv.setViewName("user-profile.jsp");
				return mv;
			} else {
				
				List<Orders> userMyOrders = new ArrayList<Orders>();
				userMyOrders = ordersRepository.findOrdersUsingEmail(email);
				mv.addObject("userMyOrders", userMyOrders);
				
				Orders userOrderSumary = new Orders();
				userOrderSumary = ordersRepository.findById(id).orElse(new Orders());
				mv.addObject("userOrderSumary", userOrderSumary);
				
				String sId = String.valueOf(id);
				List<OrderTransItemHist> userOrderDetails = new ArrayList<OrderTransItemHist>();
				userOrderDetails = orderTransItemHistRepository.findOrderTransItemHistUsingOrderId(sId);
				mv.addObject("userOrderDetails", userOrderDetails);
				
				mv.addObject("userEntry", userEntry);
				mv.setViewName("user-profile.jsp");
				return mv;
			}
		}
	}	
}
