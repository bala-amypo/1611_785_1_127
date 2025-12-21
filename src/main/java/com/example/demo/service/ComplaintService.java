package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Complaint;

public interface ComplaintService {

    Complaint postData(Complaint complaint);

    List<Complaint> getAllData();

    Complaint getData(Long id);

    String deleteData(Long id);

    Complaint updateData(Long id, Complaint complaint);

    List<Complaint> getComplaintsByCustomer(Long customerId);

    List<Complaint> getPrioritizedComplaints();
}
