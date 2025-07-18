package com.example.oauthclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Optional: disable CSRF for non-browser clients
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/error").permitAll() // Public pages
                .anyRequest().authenticated() // All other requests require authentication
            )
            .oauth2Login(oauth2 -> oauth2 // Enables OAuth2 login
                .loginPage("/login") // Optional: custom login page
            );

        return http.build();
    }
}
