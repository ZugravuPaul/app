package com.home.projectapp.controller;

import com.home.projectapp.dto.NormalUserDto;
import com.home.projectapp.dto.SellerUserDto;
import com.home.projectapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("/normaluser")
    public void Register_as_NormalUser(@RequestBody NormalUserDto normalUserDto){
        userService.addNormalUser(normalUserDto);
    }

    @PostMapping("/selleruser")
    public void Register_as_SellerUser(@RequestBody SellerUserDto sellerUserDto){
        userService.addSellerUser(sellerUserDto);
    }
}
