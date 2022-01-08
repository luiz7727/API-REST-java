package com.example.apirestjava.controller;

import com.example.apirestjava.model.User;
import com.example.apirestjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository _userRepository;

    @GetMapping("/user")
    public List<User> getAll(){
        return _userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") long id){

        Optional<User> user = _userRepository.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return _userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> putUser(@PathVariable(value = "id") long id, @RequestBody User newUser){
        Optional<User> oldUser = _userRepository.findById(id);

        if(oldUser.isPresent()){
            User user = oldUser.get();
            user.setNome(newUser.getNome());
            _userRepository.save(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") long id){
        Optional<User> user = _userRepository.findById(id);
        if (user.isPresent()){
            _userRepository.delete(user.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
