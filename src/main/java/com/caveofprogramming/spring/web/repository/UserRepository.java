package com.caveofprogramming.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caveofprogramming.spring.web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
