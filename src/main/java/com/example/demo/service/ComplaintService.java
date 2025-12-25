package com.example.demo.service;

import com.example.demo.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    List<Complaint> getAllComplaints();
    Complaint getComplaintById(Long id);
    Complaint createComplaint(Complaint complaint);  // <-- must exist
    Complaint updateComplaint(Long id, Complaint complaint);  // <-- must exist
    void deleteComplaint(Long id);
}
