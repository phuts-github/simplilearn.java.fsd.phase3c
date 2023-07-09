package com.simplilearn.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.OrderTransItemHist;
import com.simplilearn.sportyshoes.models.Orders;
import com.simplilearn.sportyshoes.repository.OrderTransItemHistRepository;
import com.simplilearn.sportyshoes.repository.OrdersRepository;
import com.simplilearn.sportyshoes.utils.ValidationChecks;

//@RestController
@Controller
public class OrdersController {
	OrdersController() {
	}

	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	OrderTransItemHistRepository orderTransItemHistRepository;

	@RequestMapping("/orderList")
	public ModelAndView orderList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			List<Orders> orderList = ordersRepository.findAll();

			if (orderList.isEmpty()) {
				mv.addObject("message", "No Orders Found");
				mv.setViewName("order-list.jsp");
				return mv;
			} else {
//				mv.addObject("oderListHeader", "Oder List");
				mv.addObject("orderList", orderList);
				mv.setViewName("order-list.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/orderById")
	public ModelAndView orderById(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {

			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("order-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				List<Orders> entry = new ArrayList<Orders>();
				Orders entry0 = ordersRepository.findById(uId).orElse(new Orders());
				entry.add(entry0);

				if (entry0 == null) {
					mv.addObject("message", "No Orders Found");
					mv.setViewName("order-add.jsp");
					return mv;
				} else {
					mv.addObject("entry", entry);
					mv.setViewName("order-add.jsp");
					return mv;
				}
			}
		}
	}
	
	@RequestMapping("/orderListByCategory")
	public ModelAndView orderListByCategory(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {

			if (id == 0) {
				mv.addObject("message", "Filter parameters required");
				mv.setViewName("order-list.jsp");
				return mv;
			} else {

				List<Orders> orderList = new ArrayList<Orders>();
				orderList = ordersRepository.findOrdersUsingCategory(id);
						
				if (orderList.isEmpty()) {
					mv.addObject("message", "No Orders Found");
					mv.setViewName("order-list.jsp");
					return mv;
				} else {
					mv.addObject("orderList", orderList);
					mv.setViewName("order-list.jsp");
					return mv;
				}
			}
		}
	}	

	@RequestMapping("/orderListByRange")
	public ModelAndView orderListByRange(HttpServletRequest request, @RequestParam String fromDate,
			@RequestParam String toDate) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			String minFromDate = "0001-01-01";
			String maxToDate = "9999-12-31";
			if (fromDate == "") {
				fromDate = minFromDate;
			}
			if (toDate == "") {
				toDate = maxToDate;
			}

			List<Orders> orderList = new ArrayList<Orders>();
			orderList = ordersRepository.findOrdersUsingOrderDateCYMD(fromDate, toDate);

			if (orderList.isEmpty()) {
				mv.addObject("message", "No Orders Found");
				mv.setViewName("order-list.jsp");
				return mv;
			} else {
				mv.addObject("orderList", orderList);
				mv.setViewName("order-list.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/orderViewDetailsById")
	public ModelAndView orderViewDetailsById(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {

			List<Orders> orderList = ordersRepository.findAll();
			mv.addObject("orderList", orderList);

			Orders orderSumary = new Orders();
			orderSumary = ordersRepository.findById(id).orElse(new Orders());
			mv.addObject("orderSumary", orderSumary);

			String sId = String.valueOf(id);
			List<OrderTransItemHist> orderDetails = new ArrayList<OrderTransItemHist>();
			orderDetails = orderTransItemHistRepository.findOrderTransItemHistUsingOrderId(sId);
			mv.addObject("orderDetails", orderDetails);

			mv.setViewName("order-list.jsp");
			return mv;

		}
	}

}
