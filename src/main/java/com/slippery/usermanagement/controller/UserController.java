package com.slippery.usermanagement.controller;

import com.slippery.usermanagement.model.User;
import com.slippery.usermanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/save/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return ResponseEntity.ok(service.saveUser(user));
    }
    @PutMapping("/update/user")
    public ResponseEntity<User> updateUser(@RequestParam Long id,@RequestBody User user){
        return ResponseEntity.ok(service.updateUser(id,user));
    }
    @GetMapping("/get/id")
    public ResponseEntity<User> getUserById(@RequestParam Long id){
        return ResponseEntity.ok(service.getUserById(id));
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.getAllUsers());
    }
    @GetMapping("/get/email")
    public ResponseEntity<List<User>> getUserByEmail(@RequestParam String email){
        return ResponseEntity.ok(service.getUserByEmail(email));
    }
    @DeleteMapping("/delete/id")
    public ResponseEntity<Boolean> deleteUserById(@RequestParam Long id){
        return ResponseEntity.ok(service.deleteUserById(id));
    }
    @PostMapping("/input/array")
    public void insertArray(@RequestBody List<User> userList) {
        for(User user : userList) {
            ResponseEntity.ok(service.saveUser(user));
        }
    }

}
