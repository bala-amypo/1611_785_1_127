package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Autowired
    private PriorityRuleRepository repository;

    @Override
    public PriorityRule addNewRule(PriorityRule rule) {
        return repository.save(rule);
    }

    @Override
    public List<PriorityRule> fetchAllRules() {
        return repository.findAll();
    }

    @Override
    public PriorityRule fetchRuleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public PriorityRule modifyRule(Long id, PriorityRule rule) {
        return repository.findById(id).map(existing -> {
            existing.setRuleName(rule.getRuleName());
            existing.setDescription(rule.getDescription());
            existing.setWeight(rule.getWeight());
            existing.setActive(rule.isActive());
            return repository.save(existing);
        }).orElse(null);
    }

    @Override
    public String removeRule(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Deleted Successfully";
        }
        return "Rule Not Found";
    }
}
