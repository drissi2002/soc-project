package com.example.demo.dtos.modelDto;

import com.example.demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RefreshTokenDto {

    private long id;
    private User user;
    private String token;
    private Instant expiryDate;
}
