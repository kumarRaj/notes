package com.wander.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wander.model.Note;
import com.wander.model.WanderUser;
import com.wander.repository.UserRepository;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;
    
    public void save(WanderUser user) {
    	userRepository.save(user);
        return;
    }
    
}
