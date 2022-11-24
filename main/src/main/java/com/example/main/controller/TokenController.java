package com.example.main.controller;

import com.example.main.dto.ResponseDto;
import com.example.main.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main/token")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService tokenService;

    @PostMapping("/accessToken")
    public ResponseDto getAccessToken(@RequestParam String email, @RequestParam String password){
        return tokenService.jwtToken(email,password);
    }

    @PostMapping("/refreshToken")
    public ResponseDto getRefreshToken(@RequestParam String refreshToken){
        return tokenService.refreshToken(refreshToken);
    }
}
