package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority-rules")
public class PriorityRuleController {

    @Autowired
    private PriorityRuleService priorityRuleService;

    @GetMapping
    public ResponseEntity<List<PriorityRule>> getAllPriorityRules() {
        return ResponseEntity.ok(priorityRuleService.getAllPriorityRules());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityRule> getPriorityRuleById(@PathVariable Long id) {
        return ResponseEntity.ok(priorityRuleService.getPriorityRuleById(id));
    }

    @PostMapping
    public ResponseEntity<PriorityRule> createPriorityRule(@RequestBody PriorityRule priorityRule) {
        return ResponseEntity.ok(priorityRuleService.createPriorityRule(priorityRule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriorityRule> updatePriorityRule(@PathVariable Long id, @RequestBody PriorityRule priorityRule) {
        return ResponseEntity.ok(priorityRuleService.updatePriorityRule(id, priorityRule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriorityRule(@PathVariable Long id) {
        priorityRuleService.deletePriorityRule(id);
        return ResponseEntity.ok().build();
    }
}
