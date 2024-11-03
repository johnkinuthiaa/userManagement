package com.slippery.usermanagement.service;

import com.slippery.usermanagement.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserById(Long id);
    User updateUser(Long id,User user);
    List<User> getAllUsers();
    List<User> getUserByEmail(String email);
    Boolean deleteUserById(Long id);

}
