package com.home.projectapp.service;

import com.home.projectapp.entity.NormalUser;
import com.home.projectapp.repository.NormalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Primary
@Service
public class NormalUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    NormalUserRepository normalUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NormalUser normalUser=normalUserRepository.findByUsername(username);
        if(normalUser!=null)
            return normalUser;
        throw new UsernameNotFoundException("user " + username + " was not found");
    }


}
