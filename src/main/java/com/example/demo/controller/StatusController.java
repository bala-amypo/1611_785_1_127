// package com.example.demo.controller;

// import com.example.demo.entity.Complaint;
// import com.example.demo.service.ComplaintService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/status")
// public class StatusController {

//     private final ComplaintService complaintService;

//     public StatusController(ComplaintService complaintService) {
//         this.complaintService = complaintService;
//     }

//     /**
//      * Get all complaints with a specific status
//      * Example: NEW, IN_PROGRESS, RESOLVED, CLOSED
//      */
//     @GetMapping("/{status}")
//     public List<Complaint> getComplaintsByStatus(
//             @PathVariable Complaint.Status status
//     ) {
//         return complaintService.getComplaintsByStatus(status);
//     }

//     /**
//      * Update complaint status
//      */
//     @PutMapping("/{complaintId}")
//     public Complaint updateComplaintStatus(
//             @PathVariable Long complaintId,
//             @RequestParam Complaint.Status status
//     ) {
//         return complaintService.updateStatus(complaintId, status);
//     }
// }
