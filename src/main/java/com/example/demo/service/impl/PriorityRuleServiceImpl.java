// package com.example.demo.service.impl;

// import com.example.demo.entity.Complaint;
// import com.example.demo.entity.PriorityRule;
// import com.example.demo.repository.PriorityRuleRepository;
// import com.example.demo.service.PriorityRuleService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class PriorityRuleServiceImpl implements PriorityRuleService {
//     private final PriorityRuleRepository priorityRuleRepository;

//     public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
//         this.priorityRuleRepository = priorityRuleRepository;
//     }

//     @Override
//     public List<PriorityRule> getActiveRules() {
//         return priorityRuleRepository.findByActiveTrue();
//     }

//     @Override
//     public int computePriorityScore(Complaint complaint) {
//         List<PriorityRule> rules = getActiveRules();
//         int score = 0;
//         for (PriorityRule rule : rules) {
//             score += rule.getWeight();
//         }
//         return score;
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    // ✅ save rule
    @Override
    public PriorityRule save(PriorityRule rule) {
        return priorityRuleRepository.save(rule);
    }

    // ✅ fetch only active rules
    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }

    // ✅ compute priority score
    @Override
    public int computePriorityScore(Complaint complaint) {

        int score = 0;

        // 1️⃣ Severity-based scoring
        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case CRITICAL:
                    score += 10;
                    break;
                case HIGH:
                    score += 5;
                    break;
                default:
                    break;
            }
        }

        // 2️⃣ Urgency-based scoring
        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case HIGH:
                    score += 3;
                    break;
                case MEDIUM:
                    score += 2;
                    break;
                default:
                    break;
            }
        }

        // 3️⃣ DB-based rules
        List<PriorityRule> rules = getActiveRules();
        for (PriorityRule rule : rules) {
            score += rule.getWeight();
        }

        return score;
    }
}
