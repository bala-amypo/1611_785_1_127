package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;

@RestController
public class PriorityRuleController {

    private PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    // GET all active rules
    @GetMapping("/rules/active")
    public List<PriorityRule> getActiveRules() {
        return priorityRuleService.getActiveRules();
    }

    // GET all rules (for simplicity, just returning active rules; you can extend)
    @GetMapping("/rules/all")
    public List<PriorityRule> getAllRules() {
        return priorityRuleService.getActiveRules(); // replace with findAll if needed
    }
}
