package com.example.main.repo;

import com.example.main.entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    void findByEmail() {
        Users users = new Users(10, "Some", "One", "Java Developer", "1010101010", "12345678", null, null, "931234523", "someone@gmail.com", null);
        userRepo.save(users);

        boolean expected = userRepo.existsById(10);
        assertThat(expected).isTrue();
    }
}