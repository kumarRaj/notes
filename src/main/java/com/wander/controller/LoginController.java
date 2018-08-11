package com.wander.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import com.wander.model.Registration;

@Controller
public class LoginController {

	
	 @RequestMapping(value = "/registration")
	    public String Registation(Model registrationForm){
		 	Registration r = new Registration();
		 	r.setFirstName("abcdef");
		 	registrationForm.addAttribute("registrationForm", r);
		 	return "registration.html";
	    }
	 @RequestMapping(value = "/registration-Form")
	    public String registerUser(@ModelAttribute("registrationForm") Registration registrationForm){
		 System.out.println("Raj Kumar"+registrationForm.getFirstName());
		 System.out.println("Raj Kumar"+registrationForm.getLastName());	
		 //registrationForm.addAttribute("registrationForm", new Registration());
		 	return "home.html";
	    }
}

