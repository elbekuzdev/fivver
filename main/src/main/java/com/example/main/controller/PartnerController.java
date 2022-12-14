package com.example.main.controller;

import com.example.main.dto.PartnerDto;
import com.example.main.dto.ResponseDto;
import com.example.main.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/main/partner")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;

    @PreAuthorize("hasAnyRole('UPDATE')")
    @PutMapping("/update/{id}")
    public ResponseDto update(@PathVariable Integer id, @Valid@RequestBody PartnerDto partnerDto){
        partnerDto.setId(id);
        return partnerService.update(id, partnerDto);
    }

    @PreAuthorize("hasAnyRole('DELETE')")
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable Integer id){
        return partnerService.deleteById(id);
    }


    }
