package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PriorityRule;

public interface PriorityRuleService {

    PriorityRule addNewRule(PriorityRule rule);

    List<PriorityRule> fetchAllRules();

    PriorityRule fetchRuleById(Long id);

    PriorityRule modifyRule(Long id, PriorityRule rule);

    String removeRule(Long id);
}
