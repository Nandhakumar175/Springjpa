package com.example.springjpa.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.entity.User;
import com.example.springjpa.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    public UserService userService;
    
    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user) {
        user.setId(UUID.randomUUID());
        user.setCreateDate(LocalDateTime.now());
        userService.saveUser(user);
        return user;
    }
    
    @GetMapping(value = "/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping(value = "/get-by-id/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public void deleteUserById(@PathVariable("id") UUID id) {
        userService.deleteUserById(id);
    }
    
    @PutMapping(value = "/update/{id}")
    public void updateUserById(@PathVariable("id") UUID id, @RequestBody User updatedUser) {
        userService.updateUserById(id, updatedUser);
    }
    
    @PutMapping(value = "/update-name/{id}")
    public void updateUserNameById(@PathVariable("id") UUID id, @RequestParam("name") String name) {
        userService.updateUserNameById(id, name);
    }
    
    @PutMapping(value = "/update-email/{id}")
    public void updateUserEmailById(@PathVariable("id") UUID id, @RequestParam("email") String email) {
        userService.updateUserEmailById(id, email);
    }
    
}

