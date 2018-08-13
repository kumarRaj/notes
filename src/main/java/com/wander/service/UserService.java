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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static java.util.Objects.isNull;

@Service
public class UserService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public String save(WanderUser user) {
        WanderUser userExists = userRepository.findByEmailid(user.getEmailid());
        if(isNull(userExists)){
            user.setUserName(user.getEmailid());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRole("USER");
            userRepository.save(user);
            return "redirect:/LoginPage";
        }
        return "redirect:/LoginPage?userPresent";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WanderUser user = userRepository.findByEmailid(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return new User(user.getUserName(),
                user.getPassword(), Collections.singletonList(authority));
    }
}
