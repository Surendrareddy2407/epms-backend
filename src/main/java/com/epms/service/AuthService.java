package com.epms.service;

import com.epms.entity.user;
import com.epms.repository.userRepository;
import com.epms.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private userRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder encoder;

    public String login(String username, String password) {

        if (username.equals("admin") && password.equals("admin123")) {

            return jwtUtil.generateToken(username, "ADMIN");
        }

        throw new RuntimeException("Invalid credentials");
    }
}