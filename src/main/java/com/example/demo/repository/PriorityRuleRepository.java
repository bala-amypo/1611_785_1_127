package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PriorityRule;

@Repository
public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    // Find all active rules
    List<PriorityRule> findByActiveTrue();

    // Optionally, find by category
    PriorityRule findByCategory(String category);
}
