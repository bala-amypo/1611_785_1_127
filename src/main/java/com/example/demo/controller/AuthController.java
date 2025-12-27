package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication", description = "User registration and authentication APIs")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Register new customer", description = "Creates a new customer user")
    @PostMapping("/register")
    public ResponseEntity<User> registerCustomer(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password) {
        User user = userService.registerCustomer(fullName, email, password);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Find user by email", description = "Retrieves user details by email")
    @GetMapping("/user/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
