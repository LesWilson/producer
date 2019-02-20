package com.example.contract.controller;

import com.example.contract.model.User;
import com.example.contract.repository.UserRepository;
import com.example.contract.transfer.IdDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    UserRepository userRepository;

    public UserController(UserRepository repository) {
        this.userRepository = repository;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<IdDTO> createUser(@RequestBody @Valid User user) {

        User savedUser = userRepository.save(user);

        return ResponseEntity
                .status(201)
                .body(new IdDTO(savedUser.getId()));
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user, @PathVariable long id) {

        // retrieve the user from db
        User existingUser = userRepository.findById(id).get();
        existingUser.updateFrom(user);

        existingUser = userRepository.save(existingUser);

        return ResponseEntity
                .status(200)
                .body(existingUser);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {

        User user = userRepository.findById(id).get();

        return ResponseEntity
                .status(200)
                .body(user);
    }


}
