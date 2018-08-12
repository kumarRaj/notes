package com.wander.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wander.model.WanderUser;

@Repository
public interface UserRepository extends CrudRepository<WanderUser, Integer> {
	
	//public User findByEmailid();
}

