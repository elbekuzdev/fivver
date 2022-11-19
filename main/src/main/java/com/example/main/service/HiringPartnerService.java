package com.example.main.service;

import com.example.main.dto.HiringPartnerDto;
import com.example.main.dto.ResponseDto;
import com.example.main.entity.HiringPartner;
import com.example.main.mapper.HiringPartnerMapper;
import com.example.main.repo.HiringPartnerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HiringPartnerService {
    private final HiringPartnerRepo hiringPartnerRepo;

    public boolean addPartner(HiringPartnerDto hiringPartnerDto) {
        HiringPartner hiringPartner = HiringPartnerMapper.toEntity(hiringPartnerDto);
        HiringPartner save = hiringPartnerRepo.save(hiringPartner);
        return save.getId() > 0;
    }

    public List<HiringPartnerDto> getAll() {
        List<HiringPartner> all = hiringPartnerRepo.findAll();
        List<HiringPartnerDto> hiringPartnerDtos = new LinkedList<>();
        for (HiringPartner hp :all) {
            if(hp.isActive()) {
                hiringPartnerDtos.add(HiringPartnerMapper.toDto(hp));
            } }return hiringPartnerDtos;
    }

    public ResponseDto getById(Integer id) {
        Optional<HiringPartner> hp = hiringPartnerRepo.findById(id);
        if(hp.isPresent()){
            return ResponseDto.getSuccess(hp);
        }return ResponseDto.getSuccess(300, "id is invalid");
    }

    public ResponseDto update(Integer id, HiringPartnerDto hiringPartnerDto){
        Optional<HiringPartner> hp = hiringPartnerRepo.findById(id);
        if(hp.isPresent()){
            return ResponseDto.getSuccess(hiringPartnerRepo.save(HiringPartnerMapper.toEntity(hiringPartnerDto)));
        }return ResponseDto.getSuccess(300, "not updated");
    }

    public ResponseDto deleteById(Integer id) {

        Optional<HiringPartner> hp = hiringPartnerRepo.findById(id);
        if(hp.isPresent()){
            hp.get().setActive(false);

            return ResponseDto.getSuccess(200, "deleted");

        }return ResponseDto.getSuccess(300, "not found");
    }
}
