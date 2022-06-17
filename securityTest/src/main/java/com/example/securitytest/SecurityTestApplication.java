package com.example.securitytest;

import com.example.securitytest.domain.Role;
import com.example.securitytest.domain.User;
import com.example.securitytest.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityTestApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "최승우", "승우", "123",  new ArrayList<>()));
            userService.saveUser(new User(null, "최승우13", "승우11", "123",  new ArrayList<>()));
            userService.saveUser(new User(null, "최승우1313", "승우22", "123",  new ArrayList<>()));
            userService.saveUser(new User(null, "최승우13131", "승우33", "123",  new ArrayList<>()));

            userService.addRoleToUser("승우", "ROLE_USER");
            userService.addRoleToUser("승우", "ROLE_MANAGER");
            userService.addRoleToUser("승우11", "ROLE_MANAGER");
            userService.addRoleToUser("승우22", "ROLE_ADMIN");
            userService.addRoleToUser("승우33", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("승우33", "ROLE_ADMIN");
            userService.addRoleToUser("승우33", "ROLE_USER");
        };
    }
}
