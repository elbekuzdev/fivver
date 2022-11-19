package com.example.main.controller;


import com.example.main.dto.HiringPartnerDto;
import com.example.main.dto.ResponseDto;
import com.example.main.service.HiringPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hiringPartner")
@RestController
public class HiringPartnerController {
    private final HiringPartnerService hiringPartnerService;

    @PostMapping
    public ResponseDto save(@RequestBody HiringPartnerDto hiringpartnerDto) {
        boolean save = hiringPartnerService.addPartner(hiringpartnerDto);
        if (save) {
            return ResponseDto.getSuccess(200, "saved");
        }
        return ResponseDto.getSuccess(202, "not saved");
    }

    @GetMapping
    public ResponseDto getAll(){
        List<HiringPartnerDto> all = hiringPartnerService.getAll();
        return ResponseDto.getSuccess(all);
    }

    @GetMapping("{id}")
    public ResponseDto getById(@PathVariable Integer id){
        return hiringPartnerService.getById(id);
    }

    @PutMapping
    public ResponseDto update(@PathVariable Integer id, @RequestBody HiringPartnerDto hiringpartnerDto){
        return hiringPartnerService.update(id, hiringpartnerDto);

    }

    @DeleteMapping
    public ResponseDto delete(Integer id){
        return hiringPartnerService.deleteById(id);
    }




}
