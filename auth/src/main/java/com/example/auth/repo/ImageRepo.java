package com.example.auth.repo;

import com.example.auth.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.Optional;

public interface ImageRepo extends JpaRepository<Image, Integer> {
    Optional<Image> findByName(String name);
}
