package com.miclaus.socialwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miclaus.socialwebapp.Service.StatusService;
import com.miclaus.socialwebapp.models.Status;

@Controller
public class HomeController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView modelAndView) {
		
		Status latestStatus = statusService.getLatest();
		
		modelAndView.getModel().put("latestStatus", latestStatus);
		modelAndView.setViewName("app.home");
		
		return modelAndView;
	}
	
}
