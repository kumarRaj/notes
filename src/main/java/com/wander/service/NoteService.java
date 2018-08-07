package com.wander.service;

import com.wander.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2018 Jubilant FoodWorks Limited . All Rights Reserved.
 * Jubilant FoodWorks PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

@Service
public class NoteService {
    private List<Note> notes = new ArrayList<>();

    public Note save(Note note) {
        notes.add(note);
        return note;
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note delete(Integer id) {
        Note note = notes.get(id);
        notes.remove(id.intValue());
        return note;
    }

    public Note update(Integer id, Note note) {
        Note noteToUpdate = notes.get(id.intValue());
        noteToUpdate.merge(note);
        return noteToUpdate;
    }
}