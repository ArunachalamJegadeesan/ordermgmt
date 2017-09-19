package com.caveofprogramming.spring.web.service;

import java.util.List;

import com.caveofprogramming.spring.web.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    List<User> getAllUsers();
    
   
}
