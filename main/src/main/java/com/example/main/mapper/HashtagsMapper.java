package com.example.main.mapper;

import com.example.main.dto.HashTagDto;
import com.example.main.entity.Hashtag;

import java.util.HashSet;
import java.util.Set;


public class HashtagsMapper {
    public static Hashtag toEntity(HashTagDto hashtagsDto){
        return new Hashtag(hashtagsDto.getId(), hashtagsDto.getName());
    }

    public static Set<Hashtag> toEntity(Set<HashTagDto> hashTagDtos){
        HashSet<Hashtag> hashtags = new HashSet<>();
        for (HashTagDto dto: hashTagDtos){
            hashtags.add(toEntity(dto));
        }
        return hashtags;
    }

    public static HashTagDto toDto(Hashtag hashtags){
        return new HashTagDto(hashtags.getId(), hashtags.getName());
    }

    public static Set<HashTagDto> toDto(Set<Hashtag> hashTagDtos){
        HashSet<HashTagDto> tagDtos = new HashSet<>();
        for (Hashtag dto: hashTagDtos){
            tagDtos.add(toDto(dto));
        }
        return tagDtos;
    }


}

