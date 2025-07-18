package com.example.oauthclient.security;

import com.example.oauthclient.config.JwtConfig;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    @Autowired
    private JwtConfig jwtConfig;

    private Key secretKey;

    @PostConstruct
    public void init() {
        String secret = jwtConfig.getSecret();

        if (secret == null || secret.trim().isEmpty()) {
            throw new IllegalArgumentException("JWT secret key is missing. Please define 'spring.security.jwt.secret' in your application.yml");
        }

        byte[] keyBytes = secret.getBytes(StandardCharsets.UTF_8);

        if (keyBytes.length < 32) {
            throw new IllegalArgumentException("Secret key must be at least 256 bits (32 bytes). Current length: " + keyBytes.length);
        }

        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // You can log the error here for debugging
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        String username = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(username, "", List.of());
    }
}
