package com.example.demo.controller;

import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority-rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    @PostMapping
    public ResponseEntity<PriorityRule> createRule(
            @RequestBody PriorityRule rule
    ) {
        return ResponseEntity.ok(priorityRuleService.save(rule));
    }

    @GetMapping("/active")
    public ResponseEntity<List<PriorityRule>> getActiveRules() {
        return ResponseEntity.ok(priorityRuleService.getActiveRules());
    }

    // ✅ COMPUTE priority score (using DTO)
    @PostMapping("/compute")
    public ResponseEntity<Integer> computePriority(
            @RequestBody ComplaintResponse request
    ) {
        Complaint complaint = new Complaint();
        complaint.setSeverity(request.getSeverity());
        complaint.setUrgency(request.getUrgency());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());

        int score = priorityRuleService.computePriorityScore(complaint);
        return ResponseEntity.ok(score);
    }
}
