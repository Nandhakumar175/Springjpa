package com.example.springjpa.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpa.entity.User;
import com.example.springjpa.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    public UserRepository userRepository;
    
    public void saveUser(User user) {
        userRepository.save(user);
    }
    
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }
    
    public void updateUserById(UUID id, User updatedUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUserName(updatedUser.getUserName());
        user.setEmailId(updatedUser.getEmailId());
        userRepository.save(updatedUser);
    }
    
    public void updateUserNameById(UUID id, String name) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUserName(name);
        userRepository.save(user);
    }
    
    public void updateUserEmailById(UUID id, String email) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUserName(email);
        userRepository.save(user);
    }
    
}
