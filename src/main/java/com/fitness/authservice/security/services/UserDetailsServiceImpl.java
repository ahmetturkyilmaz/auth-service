package com.fitness.authservice.security.services;

import com.fitness.authservice.exception.RequestException;
import com.fitness.authservice.model.User;
import com.fitness.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        try {
            User user = userRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

            return UserDetailsImpl.build(user);
        } catch (RequestException e) {
            e.printStackTrace();
        }
        return null;
    }

}
