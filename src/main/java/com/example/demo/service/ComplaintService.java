package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Complaint;

public interface ComplaintService {

    Complaint postData(Complaint complaint);

    List<Complaint> getAllData();

    Complaint getDataById(Long id);

    Complaint updateData(Long id, Complaint complaint);

    String deleteData(Long id);

    List<Complaint> getPrioritizedComplaints();
}
