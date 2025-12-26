package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

@Autowired
    private PasswordEncoder encoder;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
        ExtraStudent student = ser.CheckEmail(request.getEmail());
        if (student == null) {
            throw new RuntimeException("User Not Found");

        }
        if (!encoder.matches(request.getPassword(), student.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return "Login successful for " + student.getEmail();
    @PostMapping("/register")
    public String register() {
        return "registered";
    }
}