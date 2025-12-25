package com.example.demo.service.impl;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public List<PriorityRule> getAllPriorityRules() {
        return priorityRuleRepository.findAll();
    }

    @Override
    public PriorityRule getPriorityRuleById(Long id) {
        return priorityRuleRepository.findById(id).orElseThrow();
    }

    @Override
    public PriorityRule createPriorityRule(PriorityRule rule) {
        return priorityRuleRepository.save(rule);
    }

    @Override
    public PriorityRule updatePriorityRule(Long id, PriorityRule rule) {
        PriorityRule existing = priorityRuleRepository.findById(id).orElseThrow();
        existing.setName(rule.getName());
        existing.setPriority(rule.getPriority());
        return priorityRuleRepository.save(existing);
    }

    @Override
    public void deletePriorityRule(Long id) {
        priorityRuleRepository.deleteById(id);
    }
}
