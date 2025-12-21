package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintRepository complaintRepository;
    private PriorityRuleService priorityRuleService;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository, PriorityRuleService priorityRuleService) {
        this.complaintRepository = complaintRepository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint, User customer) {
        complaint.setCustomer(customer);
        complaint.setPriorityScore(priorityRuleService.computePriorityScore(complaint));
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User customer) {
        return complaintRepository.findByCustomer(customer);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return complaintRepository.findAllByOrderByPriorityScoreDescCreatedAtAsc();
    }

    @Override
    public Complaint updateStatus(Long id, Complaint.Status status) {
        Complaint c = complaintRepository.findById(id).orElse(null);
        if (c != null) {
            c.setStatus(status);
            return complaintRepository.save(c);
        }
        return null;
    }
}
