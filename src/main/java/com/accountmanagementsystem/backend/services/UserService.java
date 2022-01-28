package com.accountmanagementsystem.backend.services;

import com.accountmanagementsystem.backend.entities.User;
import com.accountmanagementsystem.backend.exceptions.InvalidUserException;
import com.accountmanagementsystem.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(int id) throws InvalidUserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new InvalidUserException("User id not found : "+id);
        }
        return optionalUser.get();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User save(User user) {
        return userRepository.save(user);
    }
    public User update(User user) throws InvalidUserException {
        Optional<User> optionalCustomer = userRepository.findById(user.getId());
        if(!optionalCustomer.isPresent()) {
            throw new InvalidUserException("User not existing to edit with id: "+user.getId());
        }
        return userRepository.save(user);
    }
    public User delete(int id) throws InvalidUserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new InvalidUserException("User not existing to delete with id: "+id);
        }
        User user = optionalUser.get();
        userRepository.deleteById(id);
        return user;
    }
}
