package com.home.projectapp.controller;

import com.home.projectapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
    @Autowired
    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable @Valid @Min(0) Long id){
        userService.deleteUser(id);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity handleException() {
        return ResponseEntity.badRequest().body("Bad request");
    }
}
