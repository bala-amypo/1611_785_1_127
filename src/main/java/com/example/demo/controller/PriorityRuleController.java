package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority-rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    @GetMapping
    public List<PriorityRule> getAllPriorityRules() {
        return priorityRuleService.getAllPriorityRules();
    }

    @PostMapping
    public PriorityRule createPriorityRule(@RequestBody PriorityRule rule) {
        return priorityRuleService.createPriorityRule(rule);
    }

    @PutMapping("/{id}")
    public PriorityRule updatePriorityRule(@PathVariable Long id, @RequestBody PriorityRule rule) {
        return priorityRuleService.updatePriorityRule(id, rule);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriorityRule(@PathVariable Long id) {
        priorityRuleService.deletePriorityRule(id);
        return ResponseEntity.ok().build();
    }
}
