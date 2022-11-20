package com.example.auth.controller;

import com.example.auth.dto.UsersDto;
import com.example.auth.model.ResMessage;
import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UsersController {
    private final UserService userService;

    @PostMapping("register")
    public ResMessage registerUser(@Valid@RequestBody UsersDto usersDto){
        return userService.register(usersDto);
    }

    @PostMapping("/login")
    public ResMessage loginUser(@Valid@RequestParam String email, @Valid@RequestParam String password){
        return userService.loginUser(email,password);
    }

    @GetMapping("/all")
    public ResMessage getall(){
        return userService.getAll();
    }
    @GetMapping("/id")
    public ResMessage getById(@RequestParam Integer id){
        ResMessage userById = userService.getUserById(id);
        return userById;
    }
    @DeleteMapping("/id")
    public ResMessage deleteById(@RequestParam Integer id){
        return userService.deleteById(id);
    }

}
