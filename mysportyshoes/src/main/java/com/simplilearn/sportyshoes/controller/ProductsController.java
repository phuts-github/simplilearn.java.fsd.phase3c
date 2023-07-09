package com.simplilearn.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Products;
import com.simplilearn.sportyshoes.repository.ProductsRepository;
import com.simplilearn.sportyshoes.utils.ValidationChecks;

//@RestController
@Controller
public class ProductsController {
	ProductsController() {}

	@Autowired
	private ProductsRepository productsRepository;

	@RequestMapping("/productAddUpdate")
	public ModelAndView productAddUpdate(HttpServletRequest request, @RequestParam int id,
			@RequestParam String category, @RequestParam String brand, @RequestParam String code,
			@RequestParam String descr, @RequestParam String color, @RequestParam int size, @RequestParam String status,
			@RequestParam Double price) {

		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (category == "" || brand == "" || code == "" || descr == "" || color == "" || size == 0 || status == ""
					|| price == 0.00) {
				mv.addObject("message", "All parameters required");
				mv.setViewName("product-add.jsp");
				return mv;
			} else {
				Products products = new Products();
				products.setId(id);
				products.setCategory(category);
				products.setBrand(brand);
				products.setCode(code);
				products.setDescr(descr);
				products.setColor(color);
				products.setSize(size);
				products.setStatus(status);
				products.setPrice(price);
				productsRepository.saveAndFlush(products);
				mv.addObject("message", "Added/Updated ID " + products.getId());
				mv.setViewName("product-add.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/productShopList")
	public ModelAndView productShopList() {
		ModelAndView mv = new ModelAndView();

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

	@RequestMapping("/productList")
	public ModelAndView productList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			List<Products> entries = productsRepository.findAll();

			if (entries.isEmpty()) {
				mv.addObject("message", "No Products Available");
				mv.setViewName("product-add.jsp");
				return mv;
			} else {
				mv.addObject("entries", entries);
				mv.setViewName("product-add.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/productById")
	public ModelAndView productById(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("product-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				List<Products> entry = new ArrayList<Products>();
				Products entry0 = productsRepository.findById(uId).orElse(new Products());
				entry.add(entry0);

				if (entry0 == null) {
					mv.addObject("message", "No Products Found");
					mv.setViewName("product-add.jsp");
					return mv;
				} else {
					mv.addObject("entry", entry);
					mv.setViewName("product-add.jsp");
					return mv;
				}
			}
		}
	}

	@RequestMapping("/productDeleteById")
	public ModelAndView productDeleteById(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("product-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				productsRepository.deleteById(uId);
				mv.addObject("message", "Deleted");
				mv.setViewName("product-add.jsp");
				return mv;
			}
		}
	}
}
