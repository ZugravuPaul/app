package com.home.projectapp.repository;

import com.home.projectapp.entity.NormalUser;
import org.springframework.data.repository.CrudRepository;

public interface NormalUserRepository extends CrudRepository<NormalUser, Long> {

    NormalUser findByUsername(String username);
}
