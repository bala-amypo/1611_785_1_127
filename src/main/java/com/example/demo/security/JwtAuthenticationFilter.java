package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        // 🔒 Placeholder for future JWT logic
        // Example (not implemented):
        // - Extract Authorization header
        // - Validate JWT token
        // - Set Authentication in SecurityContext

        // Continue filter chain without modification
        filterChain.doFilter(request, response);
    }
}
