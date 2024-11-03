package com.slippery.usermanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;

    public User(){}
    public User(String firstName,String lastName,String email,String role){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.role =role;
    }
    public void setId(Long id){
        this.id =id;
    }
    public Long getId(){
        return id;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
