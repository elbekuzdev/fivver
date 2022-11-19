package com.example.main.service;

import com.example.main.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagRepo extends JpaRepository<Hashtag, Integer> {
}
