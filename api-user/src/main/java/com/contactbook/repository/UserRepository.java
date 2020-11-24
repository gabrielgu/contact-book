package com.contactbook.repository;

import com.contactbook.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    boolean existsByUsernameOrEmail(String username, String password);

}
