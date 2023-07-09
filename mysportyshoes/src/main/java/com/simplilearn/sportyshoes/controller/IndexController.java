package com.simplilearn.sportyshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class IndexController {
	IndexController(){}

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
	 	mv.setViewName("index.jsp");
		return mv;
	}
}
