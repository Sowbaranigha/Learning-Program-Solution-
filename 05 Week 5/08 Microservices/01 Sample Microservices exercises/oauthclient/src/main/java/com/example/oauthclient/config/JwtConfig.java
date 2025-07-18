package com.example.oauthclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.security.jwt")
public class JwtConfig {

    /**
     * Must be at least 32 characters for HS256.
     */
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
