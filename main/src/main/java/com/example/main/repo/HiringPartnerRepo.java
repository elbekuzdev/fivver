package com.example.main.repo;

import com.example.main.entity.Hiring;
import com.example.main.entity.HiringPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface HiringPartnerRepo extends JpaRepository<HiringPartner, Integer> {
    List<HiringPartner> findByIsActive(Boolean b);
    Optional<HiringPartner> findByIsActiveAndId(Boolean b, Integer id);
}
