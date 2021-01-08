package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("greeting", "Hello! Spring Security");
		return "home";   // /WEB-INF/views/  + home + .jsp
	}

	@RequestMapping("/login.html")
	public String login(Model model) {
		return "security/login";   // /WEB-INF/views/  + security/login + .jsp
	}

	@RequestMapping("/welcome.html")
	public String welcome(Model model) {
		return "security/welcome";   // /WEB-INF/views/  + security/welcom + .jsp
	}
	
	@RequestMapping("/loginForm.html")
	public String loginForm(Model model) {
		return "security/loginForm";   //  /WEB-INF/views/  + security/loginForm + .jsp
	}
}
