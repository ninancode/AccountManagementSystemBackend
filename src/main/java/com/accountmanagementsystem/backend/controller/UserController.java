package com.accountmanagementsystem.backend.controller;

import com.accountmanagementsystem.backend.entities.User;
import com.accountmanagementsystem.backend.exceptions.InvalidUserException;
import com.accountmanagementsystem.backend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<User> findUser(@PathVariable int id) throws InvalidUserException {
        User user = userService.findById(id);
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user) {
        User userSave = userService.save(user);
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(userSave, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @PutMapping()
    public ResponseEntity<User> update (@RequestBody User user) throws InvalidUserException {
        User userUpdate = userService.update(user) ;
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(userUpdate, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable int id) throws InvalidUserException {
        User user = userService.delete(id);
        ResponseEntity<User> responseEntity = new ResponseEntity<User>(user, HttpStatus.OK);
        return responseEntity;
    }
}
