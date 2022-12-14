package com.example.main.controller;


import com.example.main.dto.ResponseDto;
import com.example.main.repo.HashtagRepo;
import com.example.main.service.HashTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/main/hashtag")
@RequiredArgsConstructor
public class HashTagController {
    private final HashTagService hashTagService;

    @PreAuthorize("hasAnyRole('DELETE')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer id){
        return hashTagService.delete(id);
    }
}
