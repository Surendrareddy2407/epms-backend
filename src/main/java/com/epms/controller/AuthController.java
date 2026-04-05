package com.epms.controller;

import com.epms.entity.user;
import com.epms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody user user) {
        return authService.login(user.getUsername(), user.getPassword());
    }
}