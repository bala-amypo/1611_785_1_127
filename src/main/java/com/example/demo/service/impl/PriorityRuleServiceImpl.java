package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;
        List<PriorityRule> rules = priorityRuleRepository.findByActiveTrue();

        for (PriorityRule rule : rules) {
            if (complaint.getCategory() != null && complaint.getCategory().equals(rule.getCategory())) {
                score += rule.getScore();
            }
        }

        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case LOW: score += 1; break;
                case MEDIUM: score += 2; break;
                case HIGH: score += 3; break;
                case CRITICAL: score += 5; break;
            }
        }

        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case LOW: score += 1; break;
                case MEDIUM: score += 2; break;
                case HIGH: score += 3; break;
                case IMMEDIATE: score += 5; break;
            }
        }

        return Math.max(score, 0);
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}
