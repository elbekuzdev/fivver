package com.example.main.controller;


import com.example.main.dto.HiringPartnerDto;
import com.example.main.dto.PartnerDto;
import com.example.main.model.ResMessage;
import com.example.main.service.HiringPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/hiringPartner")
@Controller
public class HiringPartnerController {
    private final HiringPartnerService hiringPartnerService;

    @PostMapping
    public ResMessage save(@RequestBody HiringPartnerDto hiringpartnerDto) {
        boolean save = hiringPartnerService.addPartner(hiringpartnerDto);
        if (save) {
            return ResMessage.getSuccess(200, "saved");
        }
        return ResMessage.getSuccess(202, "not saved");
    }

    @GetMapping
    public ResMessage getAll(){
        List<HiringPartnerDto> all = hiringPartnerService.getAll();
        return ResMessage.getSuccess(all);
    }

    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return hiringPartnerService.getById(id);
    }

    @PutMapping
    public ResMessage update(@PathVariable Integer id,@RequestBody HiringPartnerDto hiringpartnerDto){
        return hiringPartnerService.update(id, hiringpartnerDto);

    }

    @DeleteMapping
    public ResMessage delete(Integer id){
        return hiringPartnerService.deleteById(id);
    }




}
