package com.wander.service;

import com.wander.model.WanderUser;
import com.wander.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    public void save(WanderUser user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WanderUser user = userRepository.findByEmailid(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return new User(user.getUserName(),
                user.getPassword(), Collections.singletonList(authority));
    }
}
