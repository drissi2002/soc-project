package com.example.demo.dtos.modelDto;

import com.example.demo.models.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto {

    private Integer id;
    private ERole name;
}
