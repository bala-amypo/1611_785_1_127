package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
    Optional<Complaint> getComplaintById(Long id);
    void deleteComplaint(Long id);
}
