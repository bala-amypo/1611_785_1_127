package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    @GetMapping("/active")
    public List<PriorityRule> getActiveRules() {
        return priorityRuleService.getActiveRules();
    }

    @PostMapping
    public PriorityRule createRule(@RequestBody PriorityRule rule) {
        return priorityRuleService.save(rule);
    }

    @PutMapping("/{id}/disable")
    public void disableRule(@PathVariable Long id) {
        priorityRuleService.disableRule(id);
    }
}
