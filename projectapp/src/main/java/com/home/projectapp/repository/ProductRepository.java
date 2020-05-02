package com.home.projectapp.repository;

import com.home.projectapp.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long>
{
    @Transactional
    @Modifying
    @Query("update Product p set p.name = :name where p.id = :id")
    void updateName(@Param("id") Long id, @Param("name") String name);

}
