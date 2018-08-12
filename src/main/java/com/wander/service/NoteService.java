package com.wander.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.wander.model.Note;
import com.wander.repository.NotesRepository;



@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>();
    
    
    
    @Autowired
    private NotesRepository noteRepository;

    public Note save(Note note) {
    	noteRepository.save(note);
        return note;
    }

    public List<Note> getAllNotes() {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

		return (List<Note>) noteRepository.findAll();
    }

    public Note delete(Integer id) {
        Note note = notes.get(id);
        noteRepository.deleteById(id);
        return note;
    }

    public Note update(Integer id, Note note) {
        Note noteToUpdate = noteRepository.findById(id).get();
        noteToUpdate.merge(note);
        return noteToUpdate;
    }
}