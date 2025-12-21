// package com.example.demo.service.impl;

// import java.util.List;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import com.example.demo.entity.PriorityRule;
// import com.example.demo.entity.Complaint;
// import com.example.demo.repository.PriorityRuleRepository;
// import com.example.demo.service.PriorityRuleService;

// @Service
// public class PriorityRuleServiceImpl implements PriorityRuleService {

//     @Autowired
//     private PriorityRuleRepository priorityRuleRepository;

//     @Override
//     public int computePriorityScore(Complaint complaint) {
//         int score = 0;
//         List<PriorityRule> activeRules = priorityRuleRepository.findByActiveTrue();
//         for (PriorityRule rule : activeRules) {
//             if (complaint.getCategory() != null && complaint.getCategory().equals(rule.getCategory())) {
//                 score += rule.getWeight();
//             }
//         }

//         if (complaint.getSeverity() != null) {
//             switch (complaint.getSeverity()) {
//                 case LOW: score += 1; break;
//                 case MEDIUM: score += 3; break;
//                 case HIGH: score += 5; break;
//                 case CRITICAL: score += 8; break;
//             }
//         }

//         if (complaint.getUrgency() != null) {
//             switch (complaint.getUrgency()) {
//                 case LOW: score += 1; break;
//                 case MEDIUM: score += 3; break;
//                 case HIGH: score += 5; break;
//                 case IMMEDIATE: score += 8; break;
//             }
//         }

//         return Math.max(score, 0);
//     }

//     @Override
//     public List<PriorityRule> getActiveRules() {
//         return priorityRuleRepository.findByActiveTrue();
//     }

//     @Override
//     public List<PriorityRule> getAllRules() {
//         return priorityRuleRepository.findAll();
//     }
// }
package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.Complaint;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Autowired
    private PriorityRuleRepository priorityRuleRepository;

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;
        List<PriorityRule> rules = priorityRuleRepository.findByActiveTrue();
        for (PriorityRule rule : rules) {
            if (complaint.getCategory() != null && complaint.getCategory().equals(rule.getCategory())) {
                score += rule.getWeight();
            }
        }

        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 3;
                case HIGH -> score += 5;
                case CRITICAL -> score += 8;
            }
        }

        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case LOW -> score += 1;
                case MEDIUM -> score += 3;
                case HIGH -> score += 5;
                case IMMEDIATE -> score += 8;
            }
        }

        return score;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }

    @Override
    public List<PriorityRule> getAllRules() {
        return priorityRuleRepository.findAll();
    }
}

