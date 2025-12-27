package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
@Tag(name = "Complaint Management", description = "CRUD operations for complaints with priority scoring")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService, UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @Operation(summary = "Submit new complaint", description = "Creates complaint with automatic priority scoring")
    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(
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

    @Operation(summary = "Get prioritized complaints", description = "Returns complaints sorted by priority score DESC")
    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintService.getPrioritizedComplaints();
        return ResponseEntity.ok(complaints);
    }

    @Operation(summary = "Get user complaints", description = "Get all complaints for specific customer")
    @GetMapping("/customer/{email}")
    public ResponseEntity<List<Complaint>> getComplaintsForCustomer(@PathVariable String email) {
        User customer = userService.findByEmail(email);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        List<Complaint> complaints = complaintService.getComplaintsForUser(customer);
        return ResponseEntity.ok(complaints);
    }

    @Operation(summary = "Test complaint with high priority", description = "Quick test endpoint")
    @PostMapping("/test-high-priority")
    public ResponseEntity<Complaint> testHighPriorityComplaint() {
        ComplaintRequest request = new ComplaintRequest();
        request.setTitle("CRITICAL: Payment Failed");
        request.setDescription("Urgent payment issue - customer can't access funds");
        request.setCategory("Payments");
        request.setChannel("App");
        request.setSeverity(Complaint.Severity.CRITICAL);
        request.setUrgency(Complaint.Urgency.IMMEDIATE);

        User customer = new User();
        customer.setEmail("priority@example.com");
        customer.setFullName("Priority Customer");

        Complaint complaint = complaintService.submitComplaint(request, customer);
        return ResponseEntity.ok(complaint);
    }
}
