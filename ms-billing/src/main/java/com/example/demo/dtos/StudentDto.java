package com.example.demo.dtos;

import com.example.demo.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {

    private Long id;
    private String name;
    private String email;
    private Gender gender;
}
