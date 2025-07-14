package com.example.securitydemo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @GetMapping("/secure")
    public String securedEndpoint() {
        return "Accessed secured endpoint with valid JWT!";
    }
}
