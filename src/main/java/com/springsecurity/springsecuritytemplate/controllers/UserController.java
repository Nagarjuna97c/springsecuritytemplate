package com.springsecurity.springsecuritytemplate.controllers;

import com.springsecurity.springsecuritytemplate.models.User;
import com.springsecurity.springsecuritytemplate.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    UserService userService;
    PasswordEncoder passwordEncoder;

    @PostMapping("/create_user")
    public User createUser(@RequestBody User request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public User login(Authentication authentication) {
        return userService.getUserByEmail(authentication.getName());
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
