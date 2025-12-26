package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;

import java.util.List;

public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository repository;
    private final PriorityRuleService priorityRuleService;

    public ComplaintServiceImpl(ComplaintRepository repository,
                                Object ignored1,
                                Object ignored2,
                                PriorityRuleService priorityRuleService) {
        this.repository = repository;
        this.priorityRuleService = priorityRuleService;
    }

    @Override
    public Complaint submitComplaint(ComplaintRequest request, User customer) {
        Complaint c = new Complaint();
        c.setTitle(request.getTitle());
        c.setDescription(request.getDescription());
        c.setCategory(request.getCategory());
        c.setChannel(request.getChannel());
        c.setSeverity(request.getSeverity());
        c.setUrgency(request.getUrgency());
        c.setCustomer(customer);

        int score = priorityRuleService.computePriorityScore(c);
        c.setPriorityScore(score);

        return repository.save(c);
    }

    @Override
    public List<Complaint> getComplaintsForUser(User customer) {
        return repository.findByCustomer(customer);
    }

    @Override
    public List<Complaint> getPrioritizedComplaints() {
        return repository.findAllOrderByPriorityScoreDescCreatedAtAsc();
    }
}
