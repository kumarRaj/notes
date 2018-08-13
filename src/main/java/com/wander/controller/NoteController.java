package com.wander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        note.addAttribute("notes", noteService.getAllNotes());
		return "display.html";
    }

    @DeleteMapping(value = "/notes/{id}")
    public void deleteNote(@PathVariable(value = "id") Integer id){
        noteService.delete(id);
    }

    @GetMapping(value = "/person")
    public String getPerson(){
        return "Sunandan";
    }

    @PostMapping(value = "/addnote")
    public String add( Model note, @RequestParam String action) {
        if(action.equalsIgnoreCase("back"))
            return "hello.html";
        note.addAttribute("note", new Note());
        return "addNote.html";
    }

    @RequestMapping(value = "/displayHome")
    public String displayHome(@ModelAttribute("note") Note note){

        System.out.println("Raj Kumar"+ note.getDescription());
        noteService.save(note);
        return "redirect:/notes";
    }

}