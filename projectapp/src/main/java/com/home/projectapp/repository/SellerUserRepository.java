package com.home.projectapp.repository;

import com.home.projectapp.entity.SellerUser;
import org.springframework.data.repository.CrudRepository;

public interface SellerUserRepository extends CrudRepository<SellerUser, Long> {

    SellerUser findByUsername(String username);
}
