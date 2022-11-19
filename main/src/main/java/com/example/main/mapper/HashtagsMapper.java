package com.example.main.mapper;

import com.example.main.dto.HashtagsDto;
import com.example.main.entity.Hashtags;



public class HashtagsMapper {
    public static Hashtags toEntity(HashtagsDto hashtagsDto){
        return new Hashtags(hashtagsDto.getId(), hashtagsDto.getName(), hashtagsDto.getHiringPartner(), hashtagsDto.getHiring());
    }

    public static HashtagsDto toDto(Hashtags hashtags){
        return new HashtagsDto(hashtags.getId(), hashtags.getName(), hashtags.getHiringPartner(), hashtags.getHiring());
    }

}

