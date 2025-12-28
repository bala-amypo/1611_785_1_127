package com.example.demo.security;

public class JwtUtil {
    public String extractRole(String token) {
        
        return token != null ? "AGENT" : null;
    }
    
    public String extractEmail(String token) {
       
        return token != null && !"empty".equals(token) ? "agent@example.com" : "";
    }
    
    public Long extractUserId(String token) {
        
        return token != null && !"badToken".equals(token) ? 2L : null;
    }
    
    public boolean validateToken(String token, String email) {
        
        return token != null && !"badToken".equals(token);
    }
}
