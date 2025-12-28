package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService,
                               UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Complaint> submitComplaint(
            @RequestBody ComplaintRequest request,
            @RequestParam String email
    ) {
        User customer = userService.findByEmail(email);
        Complaint complaint = complaintService.submitComplaint(request, customer);
        return new ResponseEntity<>(complaint, HttpStatus.CREATED);
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<Complaint>> getComplaintsForUser(
            @PathVariable String email
    ) {
        User customer = userService.findByEmail(email);
        List<Complaint> complaints = complaintService.getComplaintsForUser(customer);
        return ResponseEntity.ok(complaints);
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        return ResponseEntity.ok(
                complaintService.getPrioritizedComplaints()
        );
    }
}
