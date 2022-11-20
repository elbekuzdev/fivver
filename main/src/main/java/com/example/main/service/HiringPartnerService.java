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

    public ResponseDto addPartner(HiringPartnerDto hiringPartnerDto) {
        HiringPartner hiringPartner = HiringPartnerMapper.toEntity(hiringPartnerDto);
        HiringPartner save = hiringPartnerRepo.save(hiringPartner);
        if (save.getId() > 0 ){
            return ResponseDto.getSuccess(200, "saved");
        }
        return ResponseDto.getSuccess(202, "not saved");
    }

    public List<HiringPartner> getAll() {


        return hiringPartnerRepo.findByIsActive(true);
    }

    public ResponseDto getById(Integer id) {
        Optional<HiringPartner> hp = hiringPartnerRepo.findByIsActiveAndId(true, id);
        if (hp.isPresent()) {
            return ResponseDto.getSuccess(hp);
        }
        return ResponseDto.getSuccess(300, "id is invalid");
    }

    public ResponseDto update(Integer id, HiringPartnerDto hiringPartnerDto) {
        Optional<HiringPartner> hp = hiringPartnerRepo.findById(id);
        if (hp.isPresent()) {
            return ResponseDto.getSuccess(hiringPartnerRepo.save(HiringPartnerMapper.toEntity(hiringPartnerDto)));
        }
        return ResponseDto.getSuccess(300, "not updated");
    }

    public ResponseDto deleteById(Integer id) {

        Optional<HiringPartner> hp = hiringPartnerRepo.findById(id);
        if (hp.isPresent()) {
            HiringPartner hiringPartner = hp.get();
            hiringPartner.setIsActive(false);
            hiringPartnerRepo.save(hiringPartner);
            return ResponseDto.getSuccess(200, "deleted");

        }
        return ResponseDto.getSuccess(300, "not found");
    }
}
