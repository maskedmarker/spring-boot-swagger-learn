package com.example.learn.spring.boot.swagger.controller;

import com.example.learn.spring.boot.swagger.model.User;
import com.example.learn.spring.boot.swagger.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}
