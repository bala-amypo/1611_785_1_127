// package com.example.demo.service;

// import com.example.demo.entity.Complaint;
// import com.example.demo.entity.PriorityRule;
// import java.util.List;

// public interface PriorityRuleService {
//     List<PriorityRule> getActiveRules();
//     int computePriorityScore(Complaint complaint);
// }


package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;

import java.util.List;

public interface PriorityRuleService {

    // ✅ save priority rule
    PriorityRule save(PriorityRule rule);

    // ✅ get only active rules
    List<PriorityRule> getActiveRules();

    // ✅ compute score
    int computePriorityScore(Complaint complaint);
}
