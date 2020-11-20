package com.miclaus.socialwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	@GetMapping("/login")
	String getLogin() {
		return "app.login";
	}
	
}
