package com.home.projectapp.service;

import com.home.projectapp.dto.NormalUserDto;
import com.home.projectapp.dto.SellerUserDto;
import com.home.projectapp.entity.NormalUser;
import com.home.projectapp.entity.SellerUser;
import com.home.projectapp.repository.NormalUserRepository;
import com.home.projectapp.repository.SellerUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    NormalUserRepository normalUserRepository;
    @Autowired
    SellerUserRepository sellerUserRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public void addNormalUser(NormalUserDto normalUserDto)
    {
         normalUserRepository.save(modelMapper.map(normalUserDto,NormalUser.class));
    }

    public void addSellerUser(SellerUserDto sellerUserDto)
    {
        sellerUserRepository.save(modelMapper.map(sellerUserDto, SellerUser.class));
    }

    public void deleteUser(Long id) {
        normalUserRepository.deleteById(id);
    }

}
