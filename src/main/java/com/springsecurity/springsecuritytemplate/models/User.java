package com.springsecurity.springsecuritytemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springsecurity.springsecuritytemplate.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseClass {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    @JsonIgnore
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;
}
