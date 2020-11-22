package com.miclaus.socialwebapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.miclaus.socialwebapp.models.SiteUser;
import com.miclaus.socialwebapp.service.SiteUserService;

@Controller
public class AuthController {

	@Autowired
	private SiteUserService siteUserService;
	
	@GetMapping("/login")
	ModelAndView getLogin(ModelAndView mav) {
		mav.getModel().put("user", new SiteUser());
		mav.setViewName("app.login");
		
		return mav;
	}
	
	@GetMapping("/register")
	ModelAndView getRegister(ModelAndView mAv) {
		
		SiteUser siteUser = new SiteUser();
		
		mAv.getModel().put("user", siteUser);
		mAv.setViewName("app.register");
		
		return mAv;
	}
	
	@PostMapping("/register")
	ModelAndView postRegister(ModelAndView mAv, @Valid SiteUser siteUser, BindingResult result) {
		mAv.setViewName("app.register");
		
		if(!result.hasErrors()) {
			
			siteUserService.register(siteUser);
			mAv.setViewName("redirect:/login");
			
		}
		
		return mAv;
	}
	
}
