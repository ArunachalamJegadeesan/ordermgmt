package com.caveofprogramming.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caveofprogramming.spring.web.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
