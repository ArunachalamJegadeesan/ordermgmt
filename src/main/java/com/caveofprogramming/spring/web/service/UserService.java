package com.caveofprogramming.spring.web.service;

import com.caveofprogramming.spring.web.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
