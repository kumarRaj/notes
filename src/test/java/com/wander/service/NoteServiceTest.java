package com.wander.service;

import com.wander.model.Note;
import com.wander.model.WanderUser;
import com.wander.repository.NotesRepository;
import com.wander.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {
    @Mock
    private NotesRepository noteRepository;
    @Mock
    private UserService userService;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private NoteService noteService;

    @Test
    public void shouldSaveNoteToCorrectUser(){
        WanderUser testUser = new WanderUser();
        Note note = new Note();
        when(userService.getCurrentUser()).thenReturn(testUser);
        when(noteRepository.save(note)).thenReturn(note);

        noteService.save(note);

        assertEquals(note, testUser.getNotes().get(0));
        verify(userRepository).save(testUser);
    }

    @Test
    public void shouldReturnAllNotesForCorrectUser(){
        WanderUser testUser = new WanderUser();
        Note note = new Note();
        testUser.setNotes(Collections.singletonList(note));
        when(userService.getCurrentUser()).thenReturn(testUser);

        List<Note> allNotes = noteService.getAllNotes();

        assertEquals(allNotes, testUser.getNotes());
    }
}