package com.wander.service;

import java.util.ArrayList;
import java.util.List;

import com.wander.model.WanderUser;
import com.wander.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    public Note save(Note note) {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        WanderUser user = userRepository.findByEmailid(username);
        Note savedNote = noteRepository.save(note);
        user.getNotes().add(savedNote);
    	userRepository.save(user);
        return note;
    }

    public List<Note> getAllNotes() {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        WanderUser user = userRepository.findByEmailid(username);
        return user.getNotes();
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