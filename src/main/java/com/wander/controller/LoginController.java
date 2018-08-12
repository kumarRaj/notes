package com.wander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wander.model.Note;
import com.wander.model.WanderUser;
import com.wander.service.NoteService;
import com.wander.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;

	@Autowired
	private NoteService noteservice;


	@RequestMapping(value = "/LoginPage")
	public String loginPage() {
		return "loginpage.html";
	}
	
	
	
	@RequestMapping(value = "/registration")
	public String Registation(Model registrationForm) {
		WanderUser r = new WanderUser();
		r.setFirstName("abcdef");
		registrationForm.addAttribute("registrationForm", r);
		return "registration.html";
	}

	@PostMapping(value = "/registration-Form")
	public String registerUser(@ModelAttribute("registrationForm") WanderUser wanderUser,  @RequestParam String action) {
		System.out.println("I an in registration");
		if(action.equalsIgnoreCase("cancel"))
			return "redirect:/LoginPage";
		userservice.save(wanderUser);
		return "redirect:/LoginPage";
	}
}
