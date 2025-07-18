package com.example.jwt.controller;

import com.example.jwt.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/token")
    public String getToken(@RequestParam String username) {
        return jwtTokenProvider.createToken(username);
    }

    @GetMapping("/secure")
    public String securedEndpoint() {
        return "This is a secure endpoint";
    }
}
