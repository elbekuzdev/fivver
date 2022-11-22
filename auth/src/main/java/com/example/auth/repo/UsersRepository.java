package com.example.auth.repo;

import com.example.auth.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
    Boolean existsByPhoneNumber(String phoneNumber);
}
