package com.example.auth.repo;

import com.example.auth.entity.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepo extends JpaRepository<Links,Integer> {
}
