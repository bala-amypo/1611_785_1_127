package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.Complaint;

public interface PriorityRuleService {

    int computePriorityScore(Complaint complaint);

    List<PriorityRule> getActiveRules();
}
