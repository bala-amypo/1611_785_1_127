package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/status")
@Tag(name = "Status & Health", description = "Application status and user management APIs")
public class StatusController {

    private final UserService userService;

    public StatusController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Application health check", description = "Returns application status and Swagger links")
    @GetMapping("/health")
    public Map<String, Object> health() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "🟢 UP");
        status.put("port", 9001);
        status.put("swagger", "http://localhost:9001/swagger-ui.html");
        status.put("apiDocs", "http://localhost:9001/v3/api-docs");
        status.put("endpoints", Map.of(
            "priority", "/api/priority/complaints",
            "prioritized", "/api/priority/complaints/prioritized",
            "health", "/api/status/health"
        ));
        return status;
    }

    @Operation(summary = "Register test user", description = "Creates a test customer user")
    @PostMapping("/register")
    public ResponseEntity<User> registerTestUser(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password) {
        User user = userService.registerCustomer(fullName, email, password);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Check user status", description = "Find user by email")
    @GetMapping("/user/{email}")
    public ResponseEntity<User> findUser(@PathVariable String email) {
        User user = userService.findByEmail(email);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
