package com.example.demo.dtos.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TokenRefreshResponseDto {

    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
}
