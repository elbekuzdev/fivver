package com.example.main.repo;

import com.example.main.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PartnerRepo extends JpaRepository<Partner, Integer> {


    void deleteById(Optional<Partner> hp);
}
