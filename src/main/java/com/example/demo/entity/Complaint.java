package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DigitalComplaintPrioritizationEngine {

    public enum Status {
        NEW, OPEN, IN_PROGRESS, RESOLVED, CLOSED
    }

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
    }

    private Long id;
    private String title;
    private String description;
    private String category;
    private String channel;
    private Integer priorityScore;
    private LocalDateTime createdAt;
    private Status status;
    private Severity severity;
    private Urgency urgency;
    private User customer; 
    private User assignedAgent; 
    private Set<PriorityRule> priorityRules;
}
