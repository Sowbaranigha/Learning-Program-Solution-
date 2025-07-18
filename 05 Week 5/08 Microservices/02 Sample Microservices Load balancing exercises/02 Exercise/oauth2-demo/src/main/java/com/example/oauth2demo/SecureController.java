package com.example.oauth2demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secure() {
        return "✅ This is a secure endpoint!";
    }
}
