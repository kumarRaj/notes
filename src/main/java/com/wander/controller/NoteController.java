package com.wander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wander.model.Note;
import com.wander.model.WanderUser;
import com.wander.service.NoteService;



@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    
    @PostMapping(value = "/notes")
    public Note create(@ModelAttribute("addNote") Note note){
    	
    	System.out.println("Raj Kumar1"+note.getDescription());
    	System.out.println("Raj Kumar1"+note.getTitle());
        return noteService.save(note);
    }

    @PutMapping(value = "/notes/{id}")
    public Note update(@PathVariable(value = "id") Integer id, @RequestBody Note note){
        return noteService.update(id, note);
    }

    @GetMapping(value = "/notes")
    public String getNote(Model note){
    	WanderUser user = new WanderUser();
		user.setNotes(noteService.getAllNotes());
		note.addAttribute("noteList", user);
		return "display.html";
    }

    @DeleteMapping(value = "/notes/{id}")
    public Note deleteNote(@PathVariable(value = "id") Integer id){
        return noteService.delete(id);
    }

    @GetMapping(value = "/person")
    public String getPerson(){
        return "Sunandan";
    }
}