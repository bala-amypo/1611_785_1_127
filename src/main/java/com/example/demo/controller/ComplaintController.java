package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/submit")
    public Complaint submitComplaint(@RequestBody Complaint complaint, @RequestParam Long customerId) {
        return complaintService.submitComplaint(complaint, customerId);
    }

    @GetMapping("/user/{customerId}")
    public List<Complaint> getUserComplaints(@PathVariable Long customerId) {
        return complaintService.getComplaintsForUser(customerId);
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
