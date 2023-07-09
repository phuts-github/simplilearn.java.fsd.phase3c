package com.simplilearn.userfeedback.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.userfeedback.model.Feedback;
import com.simplilearn.userfeedback.repository.FeedbackRepository;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackRepository feedbackRepository;

//	@RequestMapping("/home")
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;
	}

	@RequestMapping("/addFeedback")
//	public ModelAndView addUpdateUserfeedback(Feedback feedback) {
	public ModelAndView addUpdateUserfeedback(@RequestParam int id, @RequestParam String name,
			@RequestParam String feedback) {

		ModelAndView mv = new ModelAndView();
		System.out.println(feedback.toString());
//		if (feedback.getFeedback() == "" || feedback.getName() == "") {
		if (name == "" || feedback == "") {
			mv.addObject("message", "Both Category and Feedback required");
			mv.setViewName("home.jsp");
			return mv;
		} else {
			Feedback feedbacks= new Feedback();
			feedbacks.setId(id);
			feedbacks.setName(name);
			feedbacks.setFeedback(feedback);
			feedbackRepository.save(feedbacks);
			
			feedbackRepository.flush();
			mv.addObject("message", "Added/Updated Feedback ID " + feedbacks.getId());
			mv.setViewName("home.jsp");
			return mv;
		}
	}

	@RequestMapping("/getAllFeedback")
	public ModelAndView getAllFeedback() {
		ModelAndView mv = new ModelAndView();

		List<Feedback> entries = feedbackRepository.findAll();

		if (entries.isEmpty()) {
			mv.addObject("message", "No Feedback Available");
			mv.setViewName("home.jsp");
			return mv;
		} else {
			mv.addObject("entries", entries);
			mv.setViewName("home.jsp");
			return mv;
		}
	}

	@RequestMapping("/getFeedback")
	public ModelAndView getFeedback(@RequestParam int id) {

		ModelAndView mv = new ModelAndView();

		if (id == 0) {
			mv.addObject("message", "ID required");
			mv.setViewName("home.jsp");
			return mv;
		} else {
			Integer uId = Integer.valueOf(id);

			Feedback entry = feedbackRepository.findById(uId).orElse(new Feedback());

			if (entry == null) {
				mv.addObject("message", "No Feedback Found");
				mv.setViewName("home.jsp");
				return mv;
			} else {
				List<Feedback> entries = new ArrayList<>();
				entries.add(entry);
				mv.addObject("entries", entries);
				mv.setViewName("home.jsp");
				return mv;
			}
		}
	}
}
