package com.miclaus.socialwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miclaus.socialwebapp.Service.StatusService;
import com.miclaus.socialwebapp.models.Status;

@Controller
public class PageController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping("/")
	public ModelAndView home(ModelAndView modelAndView) {
		modelAndView.setViewName("app.home");
		return modelAndView;
	}

	@RequestMapping("/about")
	public ModelAndView about(ModelAndView modelAndView) {
		modelAndView.setViewName("app.about");
		return modelAndView;
	}

	@RequestMapping(value = "/addstatus", method = RequestMethod.GET)
	public ModelAndView addStatus(ModelAndView modelAndView) {
		
		modelAndView.setViewName("app.addstatus");
		Status latestStatus = statusService.getLatest();
		modelAndView.getModel().put("status", new Status());
		modelAndView.getModel().put("latestStatus", latestStatus);
		return modelAndView;
		
	}

	@RequestMapping(value = "/addstatus", method = RequestMethod.POST)
	public ModelAndView addstatus(ModelAndView modelAndView, Status status) {
		
		statusService.save(status);
		modelAndView.setViewName("app.addstatus");
		modelAndView.getModel().put("status", new Status());
		modelAndView.getModel().put("latestStatus", status);
		return modelAndView;
		
	}

}
