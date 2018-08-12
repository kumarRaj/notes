package com.wander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.model.Note;
import com.wander.model.User;
import com.wander.repository.UserRepository;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    
    public void save(User user) {
    	userRepository.save(user);
        return;
    }
    
}