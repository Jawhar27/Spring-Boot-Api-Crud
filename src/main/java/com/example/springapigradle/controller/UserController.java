package com.example.springapigradle.controller;

import com.example.springapigradle.exception.ResourceNotFoundException;
import com.example.springapigradle.model.User;
import com.example.springapigradle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
      return (List<User>) userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
       return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable long id){
        Optional<User> user= userRepository.findById(id);
        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user){
        User updateUser=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not exist with id:" + id));
         updateUser.setName(user.getName());

         userRepository.save(updateUser);
         return ResponseEntity.ok(updateUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>deleteEmployee(@PathVariable long id){
        User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not exist with id:" + id));
        userRepository.delete(user);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
