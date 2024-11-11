package com.slippery.usermanagement.service;

import com.slippery.usermanagement.exeptions.UserNotFoundException;
import com.slippery.usermanagement.model.User;
import com.slippery.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;
    public UserServiceImpl(UserRepository repository){
        this.repository=repository;
    }

    @Override
    public User saveUser(User user) throws UserNotFoundException{
        if(repository.findUserByEmail(user.getEmail()) !=null){
            throw new UserNotFoundException("user with email"+user.getEmail()+" already exists");
        }
        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException{
        if(repository.findById(id).isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(Long id,User user) {
        Optional<User> currentUser =repository.findById(id);
        if(currentUser.isEmpty()){
            throw new RuntimeException("user does not exist");
        }
        User updatedUser = currentUser.get();
        updatedUser.setId(id);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setRole(user.getRole());
        return repository.save(updatedUser);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public List<User> getUserByEmail(String email) {
        if(Objects.equals(email, "")){
            throw new RuntimeException("email cannot be null");
        }
        return repository.findAll().stream()
                .filter(user->user.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean deleteUserById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        repository.deleteById(id);
        return true;
    }
}
