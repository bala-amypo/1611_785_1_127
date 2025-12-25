package com.example.demo.service;

import com.example.demo.entity.PriorityRule;
import java.util.List;
import java.util.Optional;

public interface PriorityRuleService {
    PriorityRule savePriorityRule(PriorityRule priorityRule);
    List<PriorityRule> getAllPriorityRules();
    Optional<PriorityRule> getPriorityRuleById(Long id);
    void deletePriorityRule(Long id);
}
