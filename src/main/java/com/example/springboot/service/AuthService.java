package com.example.springboot.service;

import com.example.springboot.model.AuthUser;
import com.example.springboot.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class AuthService {

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public AuthUser register(String username, String email, String rawPassword) {
        if (authUserRepository.existsByUsername(username)) {
            throw new RuntimeException("Username '" + username + "' is already taken");
        }

        String hashedPassword = passwordEncoder.encode(rawPassword);

        AuthUser user = new AuthUser(username, email, hashedPassword);
        user.setCreatedAt(LocalDateTime.now());
        return authUserRepository.save(user);
    }

    public Map<String, Object> login(String username, String rawPassword) {
        AuthUser user = authUserRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return Map.of(
            "message", "Login successful",
            "userId", user.getId(),
            "username", user.getUsername()
        );
    }
}
