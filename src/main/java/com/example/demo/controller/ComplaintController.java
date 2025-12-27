package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@Tag(name = "Complaint Management", description = "APIs for managing complaints")
public class ComplaintController {
    
    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService, UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @Operation(summary = "Submit new complaint", description = "Creates a new complaint with priority scoring")
    @PostMapping
    public Complaint submitComplaint(@RequestBody ComplaintRequest request) {
        User testUser = new User();
        testUser.setEmail("test@example.com");
        testUser.setFullName("Test User");
        return complaintService.submitComplaint(request, testUser);
    }

    @Operation(summary = "Get prioritized complaints", description = "Returns complaints sorted by priority score")
    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    @Operation(summary = "Get user complaints", description = "Returns complaints for a specific user")
    @GetMapping("/user/{email}")
    public List<Complaint> getUserComplaints(@PathVariable String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return List.of();
        }
        return complaintService.getComplaintsForUser(user);
    }
}
