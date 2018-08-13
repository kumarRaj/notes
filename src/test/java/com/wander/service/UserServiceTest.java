package com.wander.service;

import com.wander.model.WanderUser;
import com.wander.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void shouldSaveUserIfNotAlreadyPresent() {
        WanderUser user = new WanderUser();
        user.setPassword("password");
        when(passwordEncoder.encode(user.getPassword())).thenReturn("EncryptedPassword");

        String redirectUrl = userService.save(user);

        assertEquals("redirect:/LoginPage", redirectUrl);
        assertEquals("EncryptedPassword", user.getPassword());
        assertEquals("USER", user.getRole());
        verify(userRepository).save(user);

    }

    @Test
    public void shouldNotSaveUserIfAlreadyPresent() {
        WanderUser user = new WanderUser();
        when(userRepository.findByEmailid(user.getEmailid())).thenReturn(mock(WanderUser.class));

        String redirectUrl = userService.save(user);

        assertEquals("redirect:/LoginPage?userPresent", redirectUrl);
        verify(userRepository, times(0)).save(user);
        verify(passwordEncoder, times(0)).encode(user.getPassword());

    }

    @Test
    public void shouldLoadUserForGivenUsername() {
        String userName = "ramshyam";
        WanderUser user = new WanderUser();
        user.setRole("USER");
        user.setPassword("password");
        user.setUserName(userName);
        when(userRepository.findByEmailid(userName)).thenReturn(user);

        UserDetails userDetails = userService.loadUserByUsername(userName);

        assertNotNull(userDetails);
        assertEquals(userName, userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
        SimpleGrantedAuthority authority = (SimpleGrantedAuthority) userDetails.getAuthorities().toArray()[0];
        assertEquals("USER", authority.getAuthority());
    }
}