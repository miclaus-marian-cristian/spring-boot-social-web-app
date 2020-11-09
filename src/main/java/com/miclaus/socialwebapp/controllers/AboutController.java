package com.miclaus.socialwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

	@RequestMapping("/about")
	public ModelAndView about(ModelAndView modelAndView) {
		modelAndView.setViewName("app.about");
		return modelAndView;
	}
	
}
