package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/api/user")
    public User postUser(@RequestBody User user) {
        
        return userService.postUser(user);
    }
    @GetMapping("/api/user")
    public List<User> getUser() {
        return userService.getUser();
    }
    @GetMapping("/api/user/id/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }
    @GetMapping("/api/user/email/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    
    @PutMapping("/api/user/{userId}")
    public User putUser(@PathVariable Long userId, @RequestBody User user) {
    
        return userService.putUser(user, userId);
    }
    @DeleteMapping("/api/user/{userId}")
    public String deleteUser(@PathVariable Long userId)
    {
        return userService.deleteUser(userId);
    }
    
}
