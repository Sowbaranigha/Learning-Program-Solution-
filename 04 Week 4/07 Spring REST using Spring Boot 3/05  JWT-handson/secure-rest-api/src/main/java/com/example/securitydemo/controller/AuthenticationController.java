package com.example.securitydemo.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // Secret key for signing JWTs (use environment variable or config for production)
    private static final String SECRET_KEY = "secretkey1234567890secretkey1234567890"; // At least 256 bits for HS256

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start: authenticate()");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String username = getUser(authHeader);
        LOGGER.debug("Extracted Username: {}", username);

        String token = generateJwt(username);
        LOGGER.debug("Generated JWT: {}", token);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End: authenticate()");
        return map;
    }

    // Extract username from Base64-encoded Basic Auth header
    private String getUser(String authHeader) {
        LOGGER.debug("Decoding Authorization header");

        // Remove "Basic " prefix
        String encodedCredentials = authHeader.substring("Basic ".length());

        // Decode Base64 encoded credentials
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes); // Format: username:password

        LOGGER.debug("Decoded credentials: {}", decodedString);

        // Extract username
        return decodedString.split(":")[0];
    }

    // Generate JWT token
    private String generateJwt(String user) {
        LOGGER.debug("Generating JWT token for user: {}", user);

        long now = System.currentTimeMillis();
        Date issueTime = new Date(now);
        Date expiryTime = new Date(now + 20 * 60 * 1000); // 20 minutes

        SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        String token = Jwts.builder()
                .setSubject(user)
                .setIssuedAt(issueTime)
                .setExpiration(expiryTime)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }
}
