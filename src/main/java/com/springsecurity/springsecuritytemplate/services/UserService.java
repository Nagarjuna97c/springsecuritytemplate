package com.springsecurity.springsecuritytemplate.services;

import com.springsecurity.springsecuritytemplate.models.User;
import com.springsecurity.springsecuritytemplate.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user =(User) userRepository.findByName(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
      List<GrantedAuthority> authorities;
      String userName, password;
      userName = user.getEmail();
      password = user.getPassword();
      authorities = new ArrayList<>();
      authorities.add(new SimpleGrantedAuthority(user.getRole().name()));

      return new org.springframework.security.core.userdetails.User(userName,password,authorities);
  }

    public User createUser(User request) {
        return userRepository.save(request);
    }

    public User getUser(Long id) {
      return userRepository.findById(id).orElse(null);
    }
}
