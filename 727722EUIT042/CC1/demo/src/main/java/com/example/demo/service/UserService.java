package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public User postUser(User user)
    {
        return userRepo.save(user);
    }
    public List<User> getUser()
    {
        return userRepo.findAll();
    }
    public Optional<User> getUserById(Long id)
    {
        return userRepo.findById(id);
    }
    public User getUserByEmail(String email) {
        // Using getUserByEmail method
         return userRepo.getUserByEmail(email);
        
        
    }
    public User putUser(User user,Long id)
    {
        User userAvail= userRepo.findById(id).orElse(null);
        if(userAvail!=null)
        {
            userAvail.setUserName(user.getUserName());
            userAvail.setEmail(user.getEmail());
            userAvail.setPassword(user.getPassword());
            return userRepo.saveAndFlush(userAvail);
        }
        else
        return null;
    }
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return ("User deleted");
    }
    
}
