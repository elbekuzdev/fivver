package com.example.main.service;

import com.example.main.dto.HiringDto;
import com.example.main.dto.ResponseDto;
import com.example.main.entity.Hiring;
import com.example.main.mapper.HiringMapper;
import com.example.main.repository.HiringRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HiringService {
    private final HiringRepo hiringRepo;

    public ResponseEntity<ResponseDto> save(HiringDto hiringDto){
        return ResponseEntity.ok(new ResponseDto(200, "ok", hiringRepo.save(HiringMapper.toEntity(hiringDto))));
    }

    public ResponseEntity<ResponseDto> getById(Integer id){
        Optional<Hiring> byId = hiringRepo.findByIdAndIsActive(id,true);
        return byId.map(hiring -> ResponseEntity.ok(new ResponseDto(200, "ok", hiring))).orElseGet(() -> ResponseEntity.ok(new ResponseDto(404, "id not found", null)));
    }

    public ResponseEntity<ResponseDto> getAll(){
        List<Hiring> all = hiringRepo.findByIsActive(true);
        LinkedList<HiringDto> hirings = new LinkedList<>();
        for (Hiring h:all) {
            hirings.add(HiringMapper.toDto(h));
        }

        return ResponseEntity.ok(new ResponseDto(200, "ok", hirings));
    }

    public ResponseEntity<ResponseDto> update(Integer id, HiringDto hiringDto){
        Optional<Hiring> byId = hiringRepo.findByIdAndIsActive(id, true);
        if (byId.isPresent()){
            return ResponseEntity.ok(new ResponseDto(200, "ok", hiringRepo.save(HiringMapper.toEntity(hiringDto))));
        }else {
            return ResponseEntity.ok(new ResponseDto(404,"id not found", null));
        }
    }

    public ResponseEntity<ResponseDto> deleteById(Integer id){
        Optional<Hiring> byIdAndActive = hiringRepo.findByIdAndIsActive(id,true);
        if (byIdAndActive.isPresent()){
//            byIdAndActive.get().setActive(false);
            byIdAndActive.get().setIsActive(false);
            return ResponseEntity.ok(new ResponseDto(200, "deleted", null));
        }else {
            return ResponseEntity.ok(new ResponseDto(200, "id not found", null));

        }
    }
}
