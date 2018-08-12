package com.wander.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wander.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	//public User findByEmailid();
}

