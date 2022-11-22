package com.example.auth.repo;

import com.example.auth.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;

@Repository
public interface RegionRepo extends JpaRepository<Region,Integer> {
        boolean findRegionByIdAndName(Integer id,String name);
}
