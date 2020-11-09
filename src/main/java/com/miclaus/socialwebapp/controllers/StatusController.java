package com.miclaus.socialwebapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.miclaus.socialwebapp.Service.StatusService;
import com.miclaus.socialwebapp.models.Status;

@Controller
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = "/addstatus", method = RequestMethod.GET)
	public ModelAndView addStatus(ModelAndView modelAndView) {
		
		modelAndView.setViewName("app.addstatus");
		Status latestStatus = statusService.getLatest();
		modelAndView.getModel().put("status", new Status());
		modelAndView.getModel().put("latestStatus", latestStatus);
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/addstatus", method = RequestMethod.POST)
	public ModelAndView addstatus(ModelAndView modelAndView, @Valid Status status, BindingResult result) {
		//if we have no errors go ahead and save...
		if(!result.hasErrors()) {
			statusService.save(status);
			modelAndView.getModel().put("status", new Status());
		}

		modelAndView.setViewName("app.addstatus");
		modelAndView.getModel().put("latestStatus", status);
		return modelAndView;
		
	}
	
}
