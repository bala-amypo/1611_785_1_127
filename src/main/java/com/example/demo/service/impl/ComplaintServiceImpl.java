package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint submitComplaint(Complaint complaint, Long customerId) {
        complaint.setCustomerId(customerId);
        complaint.setPriorityScore(computePriority(complaint));
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getComplaintsForUser(Long customerId) {
        return complaintRepository.findByCustomerId(customerId);
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

    // simple priority computation placeholder
    private Integer computePriority(Complaint complaint) {
        int score = 0;
        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case LOW: score += 1; break;
                case MEDIUM: score += 3; break;
                case HIGH: score += 5; break;
                case CRITICAL: score += 8; break;
            }
        }
        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case LOW: score += 1; break;
                case MEDIUM: score += 2; break;
                case HIGH: score += 4; break;
                case IMMEDIATE: score += 6; break;
            }
        }
        return score;
    }
}
