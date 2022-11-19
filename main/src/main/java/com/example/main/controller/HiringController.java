package com.example.main.controller;

import com.example.main.dto.HiringDto;
import com.example.main.dto.ResponseDto;
import com.example.main.repository.HiringRepo;
import com.example.main.service.HiringService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hiring")
@RequiredArgsConstructor
public class HiringController {

    @Autowired
    private final HiringService hiringService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> save(@RequestBody HiringDto hiringDto) {
        return hiringService.save(hiringDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDto> getAll() {
        return hiringService.getAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDto> getById(@PathVariable Integer id) {
        return hiringService.getById(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @RequestBody HiringDto hiringDto) {
        return hiringService.update(id, hiringDto);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        return hiringService.deleteById(id);
    }


}
