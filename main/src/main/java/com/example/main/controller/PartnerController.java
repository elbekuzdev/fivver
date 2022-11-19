package com.example.main.controller;

import com.example.main.dto.PartnerDto;
import com.example.main.model.ResMessage;
import com.example.main.service.PartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/partner")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService partnerService;


    @GetMapping
    public ResMessage getAll(){
        List<PartnerDto> all = partnerService.getAll();
        return ResMessage.getSuccess(all);
    }

    @PostMapping
    public ResMessage save(@RequestBody PartnerDto partnerDto) {
        boolean save = partnerService.addPartner(partnerDto);
        if (save) {
            return ResMessage.getSuccess(200, "saved");
        }
        return ResMessage.getSuccess(202, "not saved");
    }

    @GetMapping("{id}")
    public ResMessage getById(@PathVariable Integer id){
        return partnerService.getById(id);
    }

    @PutMapping
    public ResMessage update(@PathVariable Integer id,@RequestBody PartnerDto partnerDto){
        return partnerService.update(id, partnerDto);

    }

    @DeleteMapping
    public ResMessage delete(Integer id){
        return partnerService.deleteById(id);
    }



    }
