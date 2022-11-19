package com.example.main.service;

import com.example.main.dto.PartnerDto;
import com.example.main.dto.ResponseDto;
import com.example.main.entity.Partner;
import com.example.main.mapper.PartnerMapper;
import com.example.main.repo.PartnerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerRepo partnerRepo;


    public boolean addPartner(PartnerDto partnerDto) {
        Partner partner = PartnerMapper.toEntity(partnerDto);
        Partner save = partnerRepo.save(partner);
        return save.getId() > 0;
    }


    public List<PartnerDto> getAll() {
        List<Partner> all = partnerRepo.findAll();
        List<PartnerDto> partnerDtos = new LinkedList<>();
        for (Partner hp :all) {
            partnerDtos.add(PartnerMapper.toDto(hp));
        }return partnerDtos;
    }

    public ResponseDto getById(Integer id) {
        Optional<Partner> hp = partnerRepo.findById(id);
        if(hp.isPresent()){
            return ResponseDto.getSuccess(hp);
        }return ResponseDto.getSuccess(300, "id is invalid");
    }

    public ResponseDto update(Integer id, PartnerDto partnerDto){
        Optional<Partner> hp = partnerRepo.findById(id);
        if(hp.isPresent()){
            return ResponseDto.getSuccess(partnerRepo.save(PartnerMapper.toEntity(partnerDto)));
        }return ResponseDto.getSuccess(300, "not updated");
    }

    public ResponseDto deleteById(Integer id) {

        Optional<Partner> hp = partnerRepo.findById(id);
        if(hp.isPresent()){
            hp.get().setActive(false);
            return ResponseDto.getSuccess(200, "deleted");

        }return ResponseDto.getSuccess(300, "not found");
    }


}
