package com.miclaus.socialwebapp.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miclaus.socialwebapp.models.Status;
import com.miclaus.socialwebapp.service.StatusService;

@Controller
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@RequestMapping(value = "/editstatus", method = RequestMethod.POST)
	ModelAndView postEditStatus(ModelAndView mav, @Valid Status status, BindingResult bindingResult) {
		
		mav.setViewName("app.editstatus");
		
		if(!bindingResult.hasErrors()) {
			statusService.save(status);
			mav.setViewName("redirect:/viewstatus");
			return mav;
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/editstatus", method = RequestMethod.GET)
	ModelAndView getEditStatus(ModelAndView mav, @RequestParam(name = "id") Long id) {
		Optional<Status> optional = statusService.get(id);
		Status status;
		
		if(optional.isPresent()) {
			status = optional.get();
		}else {
			mav.setViewName("redirect:/viewstatus");
			return mav;
		}
		
		mav.getModel().put("status", status);
		mav.setViewName("app.editstatus");
		return mav;
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
	public ModelAndView addstatus(ModelAndView modelAndView, @Valid @RequestBody Status status
								,BindingResult result) 
	{
		//if we have no errors go ahead and save...
		if(!result.hasErrors()) {
			statusService.save(status);
			ModelMap modelMap = new ModelMap();		
			return new ModelAndView("redirect:/viewstatus", modelMap);
		}
		Status latestStatus = statusService.getLatest();
		modelAndView.setViewName("app.addstatus");
		modelAndView.getModel().put("latestStatus", latestStatus);
		return modelAndView;	
	}

	@RequestMapping(value = "/viewstatus", method = RequestMethod.GET)
	public ModelAndView viewAddStatus(ModelAndView modelAndView, @RequestParam(name = "p", defaultValue = "1") int pageNumber) {
		
		Page<Status> page = statusService.getPage(pageNumber);
		
		modelAndView.getModel().put("page", page);
		
		modelAndView.setViewName("app.viewstatus");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/deletestatus", method = RequestMethod.GET)
	public ModelAndView deleteStatus(ModelAndView mav, @RequestParam(name = "id") Long id) {
		
		statusService.delete(id);
		
		mav.setViewName("redirect:/viewstatus");
		return mav;
		
	}
	
}
