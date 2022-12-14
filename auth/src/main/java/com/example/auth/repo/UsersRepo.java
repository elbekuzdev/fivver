package com.example.auth.repo;

import com.example.auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {
    Boolean existsByEmail(String email);
    Optional<Users> findByEmailAndIsactive(String email,Boolean isactive);

    Boolean existsByPhoneNumber(String phoneNumber);
    List<Users> findAllByIsactive(Boolean isactive);
}
