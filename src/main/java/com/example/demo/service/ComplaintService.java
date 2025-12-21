package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Complaint;

public interface ComplaintService {

    Complaint submitComplaint(Complaint complaint, Long customerId);

    List<Complaint> getComplaintsForUser(Long customerId);

    List<Complaint> getPrioritizedComplaints();

    Complaint updateStatus(Long id, Complaint.Status status);
}
