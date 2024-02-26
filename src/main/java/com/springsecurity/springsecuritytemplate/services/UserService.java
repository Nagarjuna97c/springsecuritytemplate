package com.springsecurity.springsecuritytemplate.services;

import com.springsecurity.springsecuritytemplate.models.User;
import com.springsecurity.springsecuritytemplate.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
  UserRepository userRepository;

    public User createUser(User request) {
        return userRepository.save(request);
    }

    public User getUser(Long id) {
      return userRepository.findById(id).orElse(null);
    }

    public User findUserByName(String name) {
        return (User) userRepository.findByName(name).orElse(null);
    }
}
