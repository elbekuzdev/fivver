package com.example.main.repo;

import com.example.main.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepo extends JpaRepository<Hashtag, Integer> {

}
