package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // 👉 Register new customer
    @PostMapping("/register")
    public ResponseEntity<User> registerCustomer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        User user = userService.registerCustomer(name, email, password);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    // 👉 Get user by email
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }
}
