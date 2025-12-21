package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;

@RestController
@RequestMapping("/rules")
public class PriorityRuleController {

    @Autowired
    private PriorityRuleService service;

    @GetMapping("/active")
    public List<PriorityRule> getActiveRules() {
        return service.getActiveRules();
    }

    @GetMapping("/all")
    public List<PriorityRule> getAllRules() {
        return service.getAllRules();
    }
}
