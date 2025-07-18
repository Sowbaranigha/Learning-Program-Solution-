package com.example.oauthclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to OAuth2 Login Example!";
    }
}
