package com.simplilearn.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.models.Categories;
import com.simplilearn.sportyshoes.repository.CategoriesRepository;
import com.simplilearn.sportyshoes.utils.ValidationChecks;

@Controller
public class CategoriesController {
	CategoriesController() {}

	@Autowired
	private CategoriesRepository categoriesRepository;

	@RequestMapping("/categoryAddUpdate")
	public ModelAndView categoryAddUpdate(HttpServletRequest request, @RequestParam int id, @RequestParam String category,
			@RequestParam String name) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (category == "" || name == "") {
	 			mv.addObject("message", "All parameters required");
				mv.setViewName("category-add.jsp");
				return mv;
			} else {
				Categories categories = new Categories();
				categories.setId(id);
				categories.setCategory(category);
				categories.setName(name);
				categoriesRepository.saveAndFlush(categories);
				mv.addObject("message", "Added/Updated ID " + categories.getId());
				mv.setViewName("category-add.jsp");
				return mv;
			}
		}
	}
	
	@RequestMapping("/categoryDeleteById")
	public ModelAndView categoryDeleteById(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("category-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				categoriesRepository.deleteById(uId);
				mv.addObject("message", "Deleted");
				mv.setViewName("category-add.jsp");
				return mv;
			}
		}
	}	

	@RequestMapping("/categoryList")
	public ModelAndView categoryList(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			List<Categories> entries = categoriesRepository.findAll();

			if (entries.isEmpty()) {
				mv.addObject("message", "No Categories Available");
				mv.setViewName("category-add.jsp");
				return mv;
			} else {
				mv.addObject("entries", entries);
				mv.setViewName("category-add.jsp");
				return mv;
			}
		}
	}

	@RequestMapping("/categoryById")
	public ModelAndView categoryById(HttpServletRequest request, @RequestParam int id) {
		ModelAndView mv = new ModelAndView();

		if (!ValidationChecks.isAdminUserLoggedIn(request)) {
			mv.addObject("message", "Login first and try again");
			mv.setViewName("user-login-admin.jsp");
			return mv;
		} else {
			if (id == 0) {
				mv.addObject("message", "ID required");
				mv.setViewName("category-add.jsp");
				return mv;
			} else {
				Integer uId = Integer.valueOf(id);
				List<Categories> entry = new ArrayList<Categories>();
				Categories entry0 = categoriesRepository.findById(uId).orElse(new Categories());
				entry.add(entry0);
				
				if (entry0 == null) {
					mv.addObject("message", "No Categories Found");
					mv.setViewName("category-add.jsp");
					return mv;
				} else {
					mv.addObject("entry", entry);
					mv.setViewName("category-add.jsp");
					return mv;
				}
			}
		}
	}	
}
