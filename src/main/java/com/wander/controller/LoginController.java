package com.wander.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wander.model.Registration;

@Controller
public class LoginController {

	
	 @RequestMapping(value = "/registration")
	    public String create(Model registrationForm){
		 	registrationForm.addAttribute("registrationForm", new Registration());
		 	return "registration.html";
	    }

}
