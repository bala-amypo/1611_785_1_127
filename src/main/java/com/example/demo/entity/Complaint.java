package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "complaints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String channel;

    @Column
    private Integer priorityScore;

    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedOn; // or createdAt if your test expects that name

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Urgency urgency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private User assignedAgent;

    @ManyToMany
    @JoinTable(
        name = "complaint_priority_rules",
        joinColumns = @JoinColumn(name = "complaint_id"),
        inverseJoinColumns = @JoinColumn(name = "priority_rule_id")
    )
    private Set<PriorityRule> priorityRules;

    /* =========================
       Lifecycle Callbacks
       ========================= */

    @PrePersist
    protected void onCreate() {
        this.submittedOn = LocalDateTime.now();
        this.status = Status.NEW; // default status
    }

    /* =========================
       Enums
       ========================= */

    public enum Status {
        NEW,
        OPEN,
        IN_PROGRESS,
        RESOLVED,
        CLOSED
    }

    public enum Severity {
        LOW,
        MEDIUM,
        HIGH,
        CRITICAL
    }

    public enum Urgency {
        LOW,
        MEDIUM,
        HIGH,
        IMMEDIATE
    }
}
