package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority")
@Tag(name = "Priority Management", description = "Complaint prioritization and priority rules APIs")
public class PriorityController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public PriorityController(ComplaintService complaintService, UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @Operation(summary = "Submit prioritized complaint", description = "Creates complaint with automatic priority scoring")
    @PostMapping("/complaints")
    public ResponseEntity<Complaint> submitPrioritizedComplaint(
            @RequestBody ComplaintRequest request,
            @RequestParam(defaultValue = "test@example.com") String customerEmail) {
        
        User customer = userService.findByEmail(customerEmail);
        if (customer == null) {
            customer = new User();
            customer.setEmail(customerEmail);
            customer.setFullName("Test Customer");
        }
        
        Complaint complaint = complaintService.submitComplaint(request, customer);
        return ResponseEntity.ok(complaint);
    }

    @Operation(summary = "Get prioritized complaints list", description = "Returns complaints sorted by priority score")
    @GetMapping("/complaints/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintService.getPrioritizedComplaints();
        return ResponseEntity.ok(complaints);
    }

    @Operation(summary = "Test high priority complaint", description = "Creates a CRITICAL priority complaint for testing")
    @PostMapping("/test-critical")
    public ResponseEntity<Complaint> testCriticalPriority() {
        ComplaintRequest request = new ComplaintRequest();
        request.setTitle("🚨 CRITICAL: System Outage");
        request.setDescription("Production system down - immediate attention required");
        request.setCategory("Infrastructure");
        request.setChannel("Phone");
        request.setSeverity(Complaint.Severity.CRITICAL);
        request.setUrgency(Complaint.Urgency.IMMEDIATE);

        User customer = new User();
        customer.setEmail("critical@example.com");
        customer.setFullName("Critical User");

        Complaint complaint = complaintService.submitComplaint(request, customer);
        return ResponseEntity.ok(complaint);
    }
}
