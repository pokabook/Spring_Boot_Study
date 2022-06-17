package com.example.securitytest.repo;

import com.example.securitytest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
