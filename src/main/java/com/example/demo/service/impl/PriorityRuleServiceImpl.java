package com.example.demo.service;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    @Autowired
    private PriorityRuleRepository priorityRuleRepository;

    @Override
    public PriorityRule savePriorityRule(PriorityRule priorityRule) {
        return priorityRuleRepository.save(priorityRule);
    }

    @Override
    public List<PriorityRule> getAllPriorityRules() {
        return priorityRuleRepository.findAll();
    }

    @Override
    public Optional<PriorityRule> getPriorityRuleById(Long id) {
        return priorityRuleRepository.findById(id);
    }

    @Override
    public void deletePriorityRule(Long id) {
        priorityRuleRepository.deleteById(id);
    }
}
