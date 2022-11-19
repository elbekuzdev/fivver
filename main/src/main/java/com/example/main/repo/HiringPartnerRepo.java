package com.example.main.repo;

import com.example.main.entity.HiringPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HiringPartnerRepo extends JpaRepository<HiringPartner, Integer> {


    void deleteById(Optional<HiringPartner> hp);
}
