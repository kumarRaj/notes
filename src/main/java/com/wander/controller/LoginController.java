package com.wander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wander.model.Note;
import com.wander.model.User;
import com.wander.service.NoteService;
import com.wander.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;

	@Autowired
	private NoteService noteservice;


	@RequestMapping(value = "/registration")
	public String Registation(Model registrationForm) {
		User r = new User();
		r.setFirstName("abcdef");
		registrationForm.addAttribute("registrationForm", r);
		return "registration.html";
	}

	@PostMapping(value = "/registration-Form")
	public String registerUser(@ModelAttribute("registrationForm") User userForm, Model note) {
		System.out.println("Raj Kumar" + userForm.getFirstName());
		System.out.println("Raj Kumar" + userForm.getLastName());
		userservice.save(userForm);
		noteservice.getAllNotes();
		User user = new User();
		user.setNotes(noteservice.getAllNotes());
		note.addAttribute("noteList", user);
		return "display.html";
	}
	
	@RequestMapping(value = "/add")
	public String addNote(Model addnote) {
		addnote.addAttribute("addNote", new Note());
		return "addNote.html";
	}

	@RequestMapping(value = "/noteadd")
	public String noteadd(@ModelAttribute("addNote") Note note){
    	
    	System.out.println("Raj Kumar"+ note.getDescription());
        noteservice.save(note);
        return "hello.html";
	}
	
}
