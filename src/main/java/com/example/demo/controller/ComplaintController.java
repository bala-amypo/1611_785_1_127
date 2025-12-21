package com.example.demo.controller;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
@RequiredArgsConstructor
public class ComplaintController {

    private final ComplaintService complaintService;

    // Submit a new complaint
    @PostMapping("/submit")
    public ResponseEntity<Complaint> submitComplaint(@RequestBody ComplaintRequest request) {
        Complaint complaint = complaintService.submitComplaint(request);
        return ResponseEntity.ok(complaint);
    }

    // Get complaints for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getUserComplaints(@PathVariable Long userId) {
        List<Complaint> complaints = complaintService.getUserComplaints(userId);
        return ResponseEntity.ok(complaints);
    }

    // Get all complaints prioritized by priorityScore DESC, createdAt ASC
    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritizedComplaints() {
        List<Complaint> complaints = complaintService.getPrioritizedComplaints();
        return ResponseEntity.ok(complaints);
    }

    // Update the status of a complaint
    @PutMapping("/status/{id}")
    public ResponseEntity<Complaint> updateComplaintStatus(@PathVariable Long id,
                                                           @RequestBody StatusUpdateRequest request) {
        Complaint updatedComplaint = complaintService.updateStatus(id, request.getStatus());
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
