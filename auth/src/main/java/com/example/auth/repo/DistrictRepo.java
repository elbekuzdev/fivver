package com.example.auth.repo;

import com.example.auth.entity.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<District,Integer> {
    List<District> findByRegionId(int regionId);
    boolean findByIdAndName(Integer id,String name);

}
