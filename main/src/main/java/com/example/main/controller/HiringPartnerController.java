package com.example.main.controller;


import com.example.main.dto.HiringPartnerDto;
import com.example.main.dto.ResponseDto;
import com.example.main.entity.HiringPartner;
import com.example.main.service.HiringPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/main/hiringPartner")
@RestController
public class HiringPartnerController {
    private final HiringPartnerService hiringPartnerService;

    @PreAuthorize("hasAnyRole('CREATE')")
    @PostMapping("/add")
    public ResponseDto save(@Valid @RequestBody HiringPartnerDto hiringpartnerDto) {
        return hiringPartnerService.addPartner(hiringpartnerDto);
    }

    @GetMapping("/getAll")
    public ResponseDto getAll(){
        return ResponseDto.getSuccess(hiringPartnerService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseDto getById(@PathVariable Integer id){
        return hiringPartnerService.getById(id);
    }

    @PreAuthorize("hasAnyRole('UPDATE')")
    @PutMapping("/update/{id}")
    public ResponseDto update(@PathVariable Integer id, @Valid @RequestBody HiringPartnerDto hiringpartnerDto){
        return hiringPartnerService.update(id, hiringpartnerDto);
    }

    @PreAuthorize("hasAnyRole('DELETE')")
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Integer id){
        return hiringPartnerService.deleteById(id);
    }




}
