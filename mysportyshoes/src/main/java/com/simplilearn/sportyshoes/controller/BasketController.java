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

import com.simplilearn.sportyshoes.models.Basket;
import com.simplilearn.sportyshoes.models.OrderTransItemHist;
import com.simplilearn.sportyshoes.models.Orders;
import com.simplilearn.sportyshoes.models.Products;
import com.simplilearn.sportyshoes.models.Users;
import com.simplilearn.sportyshoes.repository.OrderTransItemHistRepository;
import com.simplilearn.sportyshoes.repository.OrdersRepository;
import com.simplilearn.sportyshoes.repository.ProductsRepository;
import com.simplilearn.sportyshoes.repository.UsersRepository;
import com.simplilearn.sportyshoes.utils.ValidationChecks;
import com.simplilearn.sportyshoes.utils.DateUtils;

//@RestController
@Controller
public class BasketController {
	BasketController() {}

	@Autowired
	private ProductsRepository productsRepository;

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Autowired
	OrderTransItemHistRepository orderTransItemHistRepository;
	
	@Autowired
	UsersRepository usersRepository;

	@RequestMapping("/basketAdd")
	public ModelAndView basketAdd(HttpServletRequest request, @RequestParam int id) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and shop again");
	 		mv.setViewName("user-login.jsp");
			return mv;
		} else {
			List<Basket> sessBasket = new ArrayList<Basket>();
			if (!(session.getAttribute("sessBasket") == null)) {
				sessBasket = (List<Basket>) session.getAttribute("sessBasket");
			}
			Integer uId = Integer.valueOf(id);
			Products product = productsRepository.findById(uId).orElse(new Products());

			Basket basket = new Basket();
			basket.setCategory(product.getCategory());
			basket.setBrand(product.getBrand());
			basket.setColor(product.getColor());
			basket.setDescr(product.getDescr());
			basket.setSize(product.getSize());
			basket.setStatus(product.getStatus());
			basket.setPrice(product.getPrice());
			sessBasket.add(basket);

			// baskets counts
			Integer basketCount = 0;
			Double basketTotal = 0.00;

			// re-order session basket id's
			Basket tempBasket = new Basket();
			for (int i = 0; i < sessBasket.size(); i++) {
				tempBasket = sessBasket.get(i);
				tempBasket.setId(i);
				sessBasket.set(i, tempBasket);
				basketCount++;
				basketTotal = basketTotal + tempBasket.getPrice();
			}

			session.setAttribute("sessBasket", sessBasket);

			List<Products> entries = productsRepository.findAll();
			mv.addObject("entries", entries);
			mv.addObject("basketentries", sessBasket);
			mv.addObject("basketCount", basketCount);
			mv.addObject("basketTotal", basketTotal);
			mv.setViewName("shop-list.jsp");
			return mv;
		}
	}

	@RequestMapping("/basketDelete")
	public ModelAndView basketDelete(HttpServletRequest request, @RequestParam int id) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and shop again");
			mv.setViewName("user-login.jsp");
			return mv;
		} else {
			List<Basket> sessBasket = new ArrayList<Basket>();
			sessBasket = (List<Basket>) session.getAttribute("sessBasket");

			sessBasket.remove(id);

			// baskets counts
			Integer basketCount = 0;
			Double basketTotal = 0.00;

			// re-order session basket id's
			Basket tempBasket = new Basket();
			for (int i = 0; i < sessBasket.size(); i++) {
				tempBasket = sessBasket.get(i);
				tempBasket.setId(i);
				sessBasket.set(i, tempBasket);
				basketCount++;
				basketTotal = basketTotal + tempBasket.getPrice();
	 		}
			session.setAttribute("sessBasket", sessBasket);

			List<Products> entries = productsRepository.findAll();
			mv.addObject("entries", entries);
			mv.addObject("basketentries", sessBasket);
			mv.addObject("basketCount", basketCount);
			mv.addObject("basketTotal", basketTotal);
			mv.setViewName("shop-list.jsp");
			return mv;
		}
	}

	@RequestMapping("/basketCheckout")
	public ModelAndView basketCheckout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and shop again");
			mv.setViewName("user-login.jsp");
			return mv;
		} else {
			List<Basket> sessBasket = new ArrayList<Basket>();
			sessBasket = (List<Basket>) session.getAttribute("sessBasket");

			// baskets counts
			Integer basketCount = 0;
			Double basketTotal = 0.00;

			// re-order session basket id's
			Basket tempBasket = new Basket();
			for (int i = 0; i < sessBasket.size(); i++) {
				tempBasket = sessBasket.get(i);
				tempBasket.setId(i);
				sessBasket.set(i, tempBasket);
				basketCount++;
				basketTotal = basketTotal + tempBasket.getPrice();
			}
			session.setAttribute("sessBasket", sessBasket);

			mv.addObject("basketentries", sessBasket);
			mv.addObject("basketCount", basketCount);
			mv.addObject("basketTotal", basketTotal);
			mv.setViewName("checkout-list.jsp");
			return mv;
		}
	}

	@RequestMapping("/basketPay")
	public ModelAndView basketPay(HttpServletRequest request, @RequestParam String cardType,
			@RequestParam String holderName, @RequestParam int cardNo, @RequestParam String expiryDate,
			@RequestParam int securityNo) {
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isUserLoggedIn(request)) {
			mv.addObject("message", "Login first and shop again");
			mv.setViewName("user-login.jsp");
			return mv;
		} else if (!ValidationChecks.isPayDetailsProvided(cardType, holderName, cardNo, expiryDate, securityNo)) {
			mv.addObject("message", "All payment details required");
			mv.setViewName("checkput-list.jsp");
			return mv;
		} else {
			List<Basket> sessBasket = new ArrayList<Basket>();
			if (!(session.getAttribute("sessBasket") == null)) {
				sessBasket = (List<Basket>) session.getAttribute("sessBasket");
			}

			Double basketTotal = 0.00;

			// re-order session basket id's
			Basket tempBasket = new Basket();
			for (int i = 0; i < sessBasket.size(); i++) {
				tempBasket = sessBasket.get(i);
				basketTotal = basketTotal + (Double) tempBasket.getPrice();
			}

			Double postage = 20.00;
			double finalPrice = postage + basketTotal;
			String email = (String) session.getAttribute("sessUser");

			Users entry = usersRepository.findByEmail(email);

 			Orders orders = new Orders();
			orders.setId(0);
			orders.setAddress(entry.getAddress());
			orders.setEmail(email);
			orders.setFinalPrice(finalPrice);
			orders.setName(entry.getName());
			orders.setPostage(postage);
			orders.setStatus("O");
			orders.setTotalPrice(basketTotal);
			orders.setArrayOfBasketItems(sessBasket.toString());

			String orderDateCYMD = DateUtils.dateYYYYMMDD();
			orders.setOrderDate(orderDateCYMD);
			ordersRepository.saveAndFlush(orders);
			
			insertOrderTransItemHist(orders.getId(), orderDateCYMD, sessBasket);

			session.setAttribute("sessBasket", null);

			List<Products> entries = productsRepository.findAll();
			mv.addObject("message", "Oder number " + orders.getId() + " placed successfully.<br> Go to Profile to view order.");
			mv.addObject("entries", entries);
			mv.addObject("basketentries", sessBasket);
			mv.setViewName("shop-list.jsp");
			return mv;
		}
	}
	
	private void insertOrderTransItemHist(int ordersId, String orderDate, List<Basket> sessBasket) {
		Basket tempBasket = new Basket();

		for (int i = 0; i < sessBasket.size(); i++) {
			OrderTransItemHist orderTransItemHist = new OrderTransItemHist();
			tempBasket = sessBasket.get(i);
			orderTransItemHist.setBrand(tempBasket.getBrand());
			orderTransItemHist.setCategory(tempBasket.getCategory());
			orderTransItemHist.setColor(tempBasket.getColor());
			orderTransItemHist.setDescr(tempBasket.getDescr());
			orderTransItemHist.setId(0);
			orderTransItemHist.setOrderDateCYMD(orderDate);
			orderTransItemHist.setOrdersId(ordersId);
			orderTransItemHist.setPrice(tempBasket.getPrice());
			orderTransItemHist.setSize(tempBasket.getSize());
			orderTransItemHist.setStatus(tempBasket.getStatus());
			orderTransItemHistRepository.saveAndFlush(orderTransItemHist);
		}
	}	
}
