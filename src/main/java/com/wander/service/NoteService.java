package com.wander.service;

import com.wander.model.Note;
import com.wander.model.WanderUser;
import com.wander.repository.NotesRepository;
import com.wander.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {
    private final NotesRepository noteRepository;
    private UserService userService;

    @Autowired
    public NoteService(NotesRepository noteRepository, UserService userService) {
        this.noteRepository = noteRepository;
        this.userService = userService;
    }


    public Note save(Note note) {
        WanderUser user = userService.getCurrentUser();
        Note savedNote = noteRepository.save(note);
        user.getNotes().add(savedNote);
//    	userRepository.save(user);
        return note;
    }

    public List<Note> getAllNotes() {
        WanderUser user = userService.getCurrentUser();
        return user.getNotes();
    }

    public void delete(Integer id) {
        noteRepository.deleteById(id);
    }

    public Note update(Integer id, Note note) {
        Note noteToUpdate = noteRepository.findById(id).get();
        noteToUpdate.merge(note);
        return noteToUpdate;
    }
}