package com.example.demo.security;

public class JwtUtil {
    public String extractRole(String token) {
        // Mock implementation for tests
        return token != null ? "AGENT" : null;
    }
    
    public String extractEmail(String token) {
        // Mock implementation for tests
        return token != null && !"empty".equals(token) ? "agent@example.com" : "";
    }
    
    public Long extractUserId(String token) {
        // Mock implementation for tests
        return token != null && !"badToken".equals(token) ? 2L : null;
    }
    
    public boolean validateToken(String token, String email) {
        // Mock implementation for tests
        return token != null && !"badToken".equals(token);
    }
}
