package com.example.securitydemo.security;

import java.io.IOException;
import java.security.Key;
import java.util.Collections;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    // Secret key must be 256-bit (32+ ASCII chars) for HS256
    private static final String SECRET = "secretkeysecretkeysecretkeysecretkey";

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("JwtAuthorizationFilter initialized");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("JWT Filter - Start");

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            LOGGER.debug("No JWT token found in header.");
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            LOGGER.debug("JWT authentication successful for user: {}", authentication.getPrincipal());
        } else {
            LOGGER.warn("JWT authentication failed or token invalid.");
        }

        chain.doFilter(request, response);
        LOGGER.debug("JWT Filter - End");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            try {
                String jwt = token.replace("Bearer ", "").trim();
                Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

                Jws<Claims> jws = Jwts.parserBuilder()
                        .setSigningKey(key)
                        .build()
                        .parseClaimsJws(jwt);

                String username = jws.getBody().getSubject();
                LOGGER.debug("Parsed username from JWT: {}", username);

                if (username != null) {
                    // No authorities are set here, for simplicity
                    return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                }

            } catch (JwtException ex) {
                LOGGER.error("JWT processing failed: {}", ex.getMessage());
            }
        }

        return null;
    }
}
