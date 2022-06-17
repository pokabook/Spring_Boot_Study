package com.example.securitytest.repo;

import com.example.securitytest.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String username);
}
