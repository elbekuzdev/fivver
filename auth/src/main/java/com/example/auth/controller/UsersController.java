package com.example.auth.controller;

import com.example.auth.dto.UsersDto;
import com.example.auth.model.ResMessage;
import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UsersController {
    private final UserService userService;

    @PostMapping("register")
    public ResMessage registerUser(@RequestBody UsersDto usersDto){
        ResMessage register = userService.register(usersDto);
        return register;
    }

}
