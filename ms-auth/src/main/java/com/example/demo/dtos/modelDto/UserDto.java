package com.example.demo.dtos.modelDto;

import com.example.demo.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

        private Long id;
        private String username;
        private String email;
        private String password;
        private Set<Role> roles = new HashSet<>();
}
