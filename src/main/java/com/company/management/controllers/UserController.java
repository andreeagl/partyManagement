package com.company.management.controllers;

import com.company.management.entities.User;
import com.company.management.services.UserService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllForUserParty();
    }

    @GetMapping(path = "/{email}")
    public User find(@PathVariable("email") String email) {
        Optional<User> userOpt = userService.findByEmail(email);
        if(userOpt.isPresent()) {
            return userOpt.get();
        } else {
            throw new RuntimeException("no user with that email");
        }
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping(path = "/{email}")
    public void delete(@PathVariable("email") String email) {
        userService.deleteByEmail(email);
    }

    @PutMapping(path = "/{email}")
    public void update(@PathVariable("email") String email, @RequestBody User user) {
      if(!userService.findByEmail(email).isPresent()) {
          ResponseEntity.badRequest().build();
      }

        userService.save(user);
    }
}
