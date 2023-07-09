package com.simplilearn.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Basket;
import com.simplilearn.sportyshoes.models.OrderTransItemHist;
import com.simplilearn.sportyshoes.repository.OrderTransItemHistRepository;
import com.simplilearn.sportyshoes.utils.ValidationChecks;

@Controller
public class OrderTransItemHistController {
	OrderTransItemHistController() {
	}

	@Autowired
	private OrderTransItemHistRepository orderTransItemHistRepository;

	public void insertOrderTransItemHist(int ordersId, String date, List<Basket> sessBasket) {
		OrderTransItemHist orderTransItemHist = new OrderTransItemHist();
		Basket tempBasket = new Basket();

		for (int i = 0; i < sessBasket.size(); i++) {
			tempBasket = sessBasket.get(i);
			orderTransItemHist.setBrand(tempBasket.getBrand());
			orderTransItemHist.setCategory(tempBasket.getCategory());
			orderTransItemHist.setColor(tempBasket.getColor());
	 		orderTransItemHist.setDescr(tempBasket.getDescr());
			orderTransItemHist.setId(0);
	 		orderTransItemHist.setOrderDateCYMD(date);
			orderTransItemHist.setOrdersId(ordersId);
			orderTransItemHist.setPrice(tempBasket.getPrice());
			orderTransItemHist.setSize(tempBasket.getSize());
			orderTransItemHist.setStatus(tempBasket.getStatus());
			orderTransItemHistRepository.saveAndFlush(orderTransItemHist);
		}
	}

	@RequestMapping("/orderAllItemHistByRange")
	public ModelAndView orderAllItemHistByRange(HttpServletRequest request, @RequestParam String fromDate,
			@RequestParam String toDate) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {

//			if (fromDate == "" || toDate == "") {
//				mv.addObject("message", "Filter parameters required");
//				mv.setViewName("order-list.jsp");
//				return mv;
//			} else {
				String minFromDate = "0001-01-01";
				String maxToDate = "9999-12-31";
				
				if (fromDate == "") {
					fromDate = minFromDate;
				}
				if (toDate == "") {
					toDate = maxToDate;
				}

				List<OrderTransItemHist> orderList = new ArrayList<OrderTransItemHist>();
				orderList = orderTransItemHistRepository.findOrderTransItemHistUsingOrderDateCYMD(fromDate, toDate);

				if (orderList.isEmpty()) {
					mv.addObject("message", "No Orders Found");
					mv.setViewName("order-list.jsp");
					return mv;
				} else {
					mv.addObject("orderList", orderList);
					mv.setViewName("order-list.jsp");
					return mv;
				}
//			}
		}
	}

	@RequestMapping("/orderAllItemHistByCategory")
	public ModelAndView orderAllItemHistByCategory(HttpServletRequest request, @RequestParam String id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {

			if (id == "") {
				mv.addObject("message", "Filter parameters required");
				mv.setViewName("order-list.jsp");
				return mv;
			} else {

				List<OrderTransItemHist> orderList = new ArrayList<OrderTransItemHist>();
				orderList = orderTransItemHistRepository.findOrderTransItemHistUsingCategory(id);

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

}
