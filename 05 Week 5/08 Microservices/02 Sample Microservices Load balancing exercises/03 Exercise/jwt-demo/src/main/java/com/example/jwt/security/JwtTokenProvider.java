package com.example.jwt.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.jwt.config.JwtConfig;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class JwtTokenProvider {

    private static final Logger logger = Logger.getLogger(JwtTokenProvider.class.getName());

    @Autowired
    private JwtConfig jwtConfig;

    private Key getSigningKey() {
        byte[] keyBytes = jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(String username) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            logger.warning("JWT expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.warning("Unsupported JWT: " + e.getMessage());
        } catch (MalformedJwtException e) {
            logger.warning("Malformed JWT: " + e.getMessage());
        } catch (SignatureException e) {
            logger.warning("Invalid JWT signature: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.warning("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
