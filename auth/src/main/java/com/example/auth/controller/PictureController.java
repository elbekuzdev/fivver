package com.example.auth.controller;

import com.example.auth.dto.ResponseDto;
import com.example.auth.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign/picture")
public class PictureController {

    private final ImageService imageService;

    @PostMapping("/save")
    public ResponseDto save(@RequestParam MultipartFile file, @RequestParam int userId) throws IOException {
        return imageService.uploadImage(file, userId);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable int id) throws IOException {
        return imageService.downloadImage(id);
    }

}
