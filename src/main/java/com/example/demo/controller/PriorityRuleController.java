package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    private PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    @GetMapping("/all")
    public List<PriorityRule> getAllRules() {
        return priorityRuleService.getActiveRules();
    }
}
