package com.simplilearn.healthcareapi.configuration;

import com.simplilearn.healthcareapi.users.UserEntity;
import com.simplilearn.healthcareapi.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserSecurityDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.getUserEntityByUserName(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User could not be found");
        }

        return new UserSecurityDetails(userEntity);
    }
}
