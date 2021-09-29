package com.securemetric.infomanager.service;

import com.securemetric.infomanager.entity.User;
import com.securemetric.infomanager.repository.UserRepository;
import com.securemetric.infomanager.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username not found.");
        }
        UserDetails userDetails = new UserDetailsImpl(user);
        return userDetails;
    }
}
