package com.springsecurity.springsecuritytemplate.repositories;

import com.springsecurity.springsecuritytemplate.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<Object> findByName(String username);

    Optional<User> findUserByEmail(String email);
}
