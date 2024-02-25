package com.springsecurity.springsecuritytemplate.controllers;

import com.springsecurity.springsecuritytemplate.models.User;
import com.springsecurity.springsecuritytemplate.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {
    UserService userService;
    PasswordEncoder passwordEncoder;

    @PostMapping("/user")
    public User createUser(@RequestBody User request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return userService.createUser(request);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }

}
