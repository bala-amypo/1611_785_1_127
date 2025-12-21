package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private ComplaintService complaintService;

    // ✅ Constructor Injection
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody Complaint complaint, @RequestParam Long userId) {
        User customer = new User();
        customer.setId(userId);
        return complaintService.submitComplaint(complaint, customer);
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        User customer = new User();
        customer.setId(userId);
        return complaintService.getComplaintsForUser(customer);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritizedComplaints() {
        return complaintService.getPrioritizedComplaints();
    }

    @PutMapping("/status/{id}")
    public Complaint changeComplaintStatus(@PathVariable Long id, @RequestParam Complaint.Status status) {
        return complaintService.updateStatus(id, status);
    }
}
