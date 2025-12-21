package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;

@RestController
@RequestMapping("/priority-rules")
public class PriorityRuleController {

    @Autowired
    private PriorityRuleService service;

    @PostMapping("/add")
    public ResponseEntity<PriorityRule> addRule(@RequestBody PriorityRule rule) {
        return ResponseEntity.ok(service.addNewRule(rule));
    }

    @GetMapping("/list")
    public ResponseEntity<List<PriorityRule>> listRules() {
        return ResponseEntity.ok(service.fetchAllRules());
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<PriorityRule> viewRule(@PathVariable Long id) {
        PriorityRule rule = service.fetchRuleById(id);
        if (rule == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rule);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<PriorityRule> editRule(@PathVariable Long id, @RequestBody PriorityRule rule) {
        PriorityRule updated = service.modifyRule(id, rule);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeRule(@PathVariable Long id) {
        return ResponseEntity.ok(service.removeRule(id));
    }
}
