package com.wander.controller;

import com.wander.model.Note;
import com.wander.model.Person;
import com.wander.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping(value = "/notes")
    public Note create(@RequestBody Note note){
        return noteService.save(note);
    }

    @PutMapping(value = "/notes/{id}")
    public Note update(@PathVariable(value = "id") Integer id, @RequestBody Note note){
        return noteService.update(id, note);
    }

    @GetMapping(value = "/notes")
    public List<Note> getNote(){
        return noteService.getAllNotes();
    }

    @DeleteMapping(value = "/notes/{id}")
    public Note deleteNote(@PathVariable(value = "id") Integer id){
        return noteService.delete(id);
    }

    @GetMapping(value = "/person")
    public Person getPerson(){
        return new Person("Sunandan");
    }
}