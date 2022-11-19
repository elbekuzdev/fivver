package com.example.main.repo;

import com.example.main.entity.Hashtags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagsRepo extends JpaRepository<Hashtags, Integer> {

}
