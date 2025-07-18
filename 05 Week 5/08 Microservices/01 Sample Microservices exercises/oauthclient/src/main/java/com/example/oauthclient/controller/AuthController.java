package com.example.oauthclient.controller;

import com.example.oauthclient.security.JwtTokenProvider; // Make sure this path matches your actual package
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // ⚠️ Replace with proper authentication logic in production
        if ("admin".equals(username) && "password".equals(password)) {
            String token = jwtTokenProvider.createToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Invalid credentials"));
    }
}
