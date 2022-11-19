package com.example.main.controller;

import com.example.main.dto.PartnerDto;
import com.example.main.dto.ResponseDto;
import com.example.main.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;


    @GetMapping
    public ResponseDto getAll(){
        List<PartnerDto> all = partnerService.getAll();
        return ResponseDto.getSuccess(all);
    }

    @PostMapping
    public ResponseDto save(@RequestBody PartnerDto partnerDto) {
        boolean save = partnerService.addPartner(partnerDto);
        if (save) {
            return ResponseDto.getSuccess(200, "saved");
        }
        return ResponseDto.getSuccess(202, "not saved");
    }

    @GetMapping("{id}")
    public ResponseDto getById(@PathVariable Integer id){
        return partnerService.getById(id);
    }

    @PutMapping
    public ResponseDto update(@PathVariable Integer id, @RequestBody PartnerDto partnerDto){
        return partnerService.update(id, partnerDto);

    }

    @DeleteMapping
    public ResponseDto delete(Integer id){
        return partnerService.deleteById(id);
    }



    }
