package com.example.auth.controller;

import com.example.auth.dto.UsersDto;
import com.example.auth.dto.ResponseDto;
import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign/auth")
public class UsersController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseDto registerUser(@Valid@RequestBody UsersDto usersDto){
        return userService.register(usersDto);
    }

    @PostMapping("/login")
    public ResponseDto loginUser(@Valid@RequestParam String email, @Valid@RequestParam String password){
        return userService.loginUser(email,password);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteById(@PathVariable Integer id){
        return userService.deleteById(id);
    }


}
