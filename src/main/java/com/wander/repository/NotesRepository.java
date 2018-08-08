package com.wander.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wander.model.Note;

@Repository
public interface NotesRepository extends CrudRepository<Note, Integer> {
	
}
