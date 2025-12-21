package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/submit")
    public ResponseEntity<Complaint> submitComplaint(@RequestBody ComplaintRequest request) {
        Complaint complaint = complaintService.submitComplaint(request);
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getUserComplaints(@PathVariable Long userId) {
        List<Complaint> complaints = complaintService.getUserComplaints(userId);
        return ResponseEntity.ok(complaints);
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintService.getPrioritizedComplaints();
        return ResponseEntity.ok(complaints);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Complaint> updateComplaintStatus(@PathVariable Long id,
                                                           @RequestBody StatusUpdateRequest request) {
        Complaint updatedComplaint = complaintService.updateStatus(id, request.status);
        return ResponseEntity.ok(updatedComplaint);
    }

    // DTO for updating status
    public static class StatusUpdateRequest {
        private Complaint.Status status;

        public Complaint.Status getStatus() {
            return status;
        }

        public void setStatus(Complaint.Status status) {
            this.status = status;
        }
    }
}
