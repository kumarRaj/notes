package com.wander.controller;

import com.wander.model.WanderUser;
import com.wander.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private final UserService userservice;

	@Autowired
	public LoginController(UserService userservice) {
		this.userservice = userservice;
	}

	@RequestMapping(value = "/LoginPage")
	public String loginPage() {
		return "loginpage.html";
	}
	
	
	
	@RequestMapping(value = "/registration")
	public String Registration(Model registrationForm) {
		WanderUser r = new WanderUser();
		r.setFirstName("abcdef");
		registrationForm.addAttribute("registrationForm", r);
		return "registration.html";
	}

	@PostMapping(value = "/registration-Form")
	public String registerUser(@ModelAttribute("registrationForm") WanderUser wanderUser,  @RequestParam String action) {
		if(action.equalsIgnoreCase("cancel"))
			return "redirect:/LoginPage";
		return userservice.save(wanderUser);
	}
}
