package com.slippery.usermanagement.repository;


import com.slippery.usermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
