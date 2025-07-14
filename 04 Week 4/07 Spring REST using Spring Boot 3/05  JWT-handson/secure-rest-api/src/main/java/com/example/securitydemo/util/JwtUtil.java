package com.example.securitydemo.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    private static final String SECRET_KEY = "mysupersecretkeymysupersecretkey123"; // at least 256 bits
    private static final long EXPIRATION_TIME_MILLIS = 1000 * 60 * 60; // 1 hour

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    /**
     * Generate JWT token with username as subject
     */
    public String generateToken(String username) {
        LOGGER.info("Generating token for user: {}", username);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_MILLIS))
                .signWith(key)
                .compact();
    }

    /**
     * Extract username from JWT token
     */
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Validate JWT token (signature + expiration)
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            LOGGER.warn("Token expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            LOGGER.warn("Unsupported JWT: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            LOGGER.warn("Malformed JWT: {}", e.getMessage());
        } catch (SecurityException e) {
            LOGGER.warn("Invalid signature: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            LOGGER.warn("Empty or null token: {}", e.getMessage());
        }
        return false;
    }
}
