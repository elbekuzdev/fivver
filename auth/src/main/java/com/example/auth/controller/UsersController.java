package com.example.auth.controller;

import com.example.auth.dto.UsersDto;
import com.example.auth.dto.ResponseDto;
import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('DELETE')")
    @GetMapping("/getAll")
    public ResponseDto getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto deleteById(@PathVariable Integer id){
        return userService.deleteById(id);
    }

    @PreAuthorize("hasAnyRole('UPDATE')")
    @PutMapping("/update")
    public ResponseDto update(@RequestBody UsersDto usersDto){
        return userService.update(usersDto);
    }


}
