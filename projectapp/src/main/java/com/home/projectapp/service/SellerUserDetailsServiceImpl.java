package com.home.projectapp.service;

import com.home.projectapp.entity.SellerUser;
import com.home.projectapp.repository.SellerUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SellerUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    SellerUserRepository sellerUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException{
        SellerUser sellerUser=sellerUserRepository.findByUsername(username);
        if(sellerUser!=null)
            return sellerUser;
        throw new UsernameNotFoundException("User " + username + " was not found");
    }
}
