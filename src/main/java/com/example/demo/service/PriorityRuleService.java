package com.example.demo.service;

import com.example.demo.entity.PriorityRule;

import java.util.List;

public interface PriorityRuleService {
    List<PriorityRule> getAllPriorityRules();
    PriorityRule getPriorityRuleById(Long id);
    PriorityRule createPriorityRule(PriorityRule rule);  // <-- must exist
    PriorityRule updatePriorityRule(Long id, PriorityRule rule);  // <-- must exist
    void deletePriorityRule(Long id);
}
