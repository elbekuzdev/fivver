package com.example.main.controller;

import com.example.main.dto.HiringDto;
import com.example.main.dto.ResponseDto;
import com.example.main.service.HiringService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/main/hiring")
@RequiredArgsConstructor
public class HiringController {

    private final HiringService hiringService;

    @PreAuthorize("hasAnyRole('CREATE')")
    @PostMapping("/add")
    public ResponseEntity<ResponseDto> save(@Valid@RequestBody HiringDto hiringDto) {
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

    @PreAuthorize("hasAnyRole('UPDATE')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer id, @Valid@RequestBody HiringDto hiringDto) {
        return hiringService.update(id, hiringDto);
    }

    @PreAuthorize("hasAnyRole('DELETE')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id) {
        return hiringService.deleteById(id);
    }


}
