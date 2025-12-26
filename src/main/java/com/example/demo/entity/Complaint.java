// // package com.example.demo.entity;

// // import jakarta.persistence.*;
// // import java.time.LocalDateTime;
// // import java.util.ArrayList;
// // import java.util.List;

// // @Entity
// // @Table(name = "complaints")
// // public class Complaint {
// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;
    
// //     private String title;
// //     private String description;
// //     private String category;
// //     private String channel;
    
// //     @Enumerated(EnumType.STRING)
// //     private Severity severity;
    
// //     @Enumerated(EnumType.STRING)
// //     private Urgency urgency;
    
// //     @Enumerated(EnumType.STRING)
// //     private Status status = Status.NEW;
    
// //     @Column(name = "priority_score")
// //     private Integer priorityScore = 0;
    
// //     @Column(name = "created_at")
// //     private LocalDateTime createdAt = LocalDateTime.now();
    
// //     @ManyToOne
// //     @JoinColumn(name = "customer_id")
// //     private User customer;
    
// //     @ManyToOne
// //     @JoinColumn(name = "assigned_agent_id")
// //     private User assignedAgent;
    
// //     @ManyToMany
// //     @JoinTable(
// //         name = "complaint_priority_rules",
// //         joinColumns = @JoinColumn(name = "complaint_id"),
// //         inverseJoinColumns = @JoinColumn(name = "priority_rule_id")
// //     )
// //     private List<PriorityRule> priorityRules = new ArrayList<>();

// //     public enum Severity {
// //         LOW, MEDIUM, HIGH, CRITICAL
// //     }
    
// //     public enum Urgency {
// //         LOW, MEDIUM, HIGH, IMMEDIATE
// //     }
    
// //     public enum Status {
// //         NEW, IN_PROGRESS, RESOLVED, CLOSED
// //     }

// //     // Constructors
// //     public Complaint() {}

// //     // Getters and Setters
// //     public Long getId() { return id; }
// //     public void setId(Long id) { this.id = id; }
    
// //     public String getTitle() { return title; }
// //     public void setTitle(String title) { this.title = title; }
    
// //     public String getDescription() { return description; }
// //     public void setDescription(String description) { this.description = description; }
    
// //     public String getCategory() { return category; }
// //     public void setCategory(String category) { this.category = category; }
    
// //     public String getChannel() { return channel; }
// //     public void setChannel(String channel) { this.channel = channel; }
    
// //     public Severity getSeverity() { return severity; }
// //     public void setSeverity(Severity severity) { this.severity = severity; }
    
// //     public Urgency getUrgency() { return urgency; }
// //     public void setUrgency(Urgency urgency) { this.urgency = urgency; }
    
// //     public Status getStatus() { return status; }
// //     public void setStatus(Status status) { this.status = status; }
    
// //     public Integer getPriorityScore() { return priorityScore; }
// //     public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }
    
// //     public LocalDateTime getCreatedAt() { return createdAt; }
// //     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
// //     public User getCustomer() { return customer; }
// //     public void setCustomer(User customer) { this.customer = customer; }
    
// //     public User getAssignedAgent() { return assignedAgent; }
// //     public void setAssignedAgent(User assignedAgent) { this.assignedAgent = assignedAgent; }
    
// //     public List<PriorityRule> getPriorityRules() { return priorityRules; }
// //     public void setPriorityRules(List<PriorityRule> priorityRules) { this.priorityRules = priorityRules; }
// // }

// package com.example.demo.entity;

// import jakarta.persistence.*;

// import java.util.HashSet;
// import java.util.Set;

// @Entity
// public class Complaint {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
//     @Column(length = 2000)
//     private String description;
//     private String category;
//     private String channel;

//     @Enumerated(EnumType.STRING)
//     private Severity severity;

//     @Enumerated(EnumType.STRING)
//     private Urgency urgency;

//     @Enumerated(EnumType.STRING)
//     private Status status = Status.NEW;

//     @ManyToOne
//     private User customer;

//     @ManyToOne
//     private User assignedAgent;

//     private Integer priorityScore;

//     // IMPORTANT: use Set and initialize it
//     @ManyToMany
//     @JoinTable(
//             name = "complaint_priority_rule",
//             joinColumns = @JoinColumn(name = "complaint_id"),
//             inverseJoinColumns = @JoinColumn(name = "rule_id")
//     )
//     private Set<PriorityRule> priorityRules = new HashSet<>();

//     public Complaint() { }

//     // ===== enums =====
//     public enum Status {
//         NEW, IN_PROGRESS, RESOLVED, CLOSED
//     }

//     public enum Severity {
//         LOW, MEDIUM, HIGH, CRITICAL
//     }

//     public enum Urgency {
//         LOW, MEDIUM, HIGH, IMMEDIATE
//     }

//     // ===== getters / setters =====

//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public String getCategory() { return category; }
//     public void setCategory(String category) { this.category = category; }

//     public String getChannel() { return channel; }
//     public void setChannel(String channel) { this.channel = channel; }

//     public Severity getSeverity() { return severity; }
//     public void setSeverity(Severity severity) { this.severity = severity; }

//     public Urgency getUrgency() { return urgency; }
//     public void setUrgency(Urgency urgency) { this.urgency = urgency; }

//     public Status getStatus() { return status; }
//     public void setStatus(Status status) { this.status = status; }

//     public User getCustomer() { return customer; }
//     public void setCustomer(User customer) { this.customer = customer; }

//     public User getAssignedAgent() { return assignedAgent; }
//     public void setAssignedAgent(User assignedAgent) { this.assignedAgent = assignedAgent; }

//     public Integer getPriorityScore() { return priorityScore; }
//     public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }

//     public Set<PriorityRule> getPriorityRules() { return priorityRules; }
//     public void setPriorityRules(Set<PriorityRule> priorityRules) { this.priorityRules = priorityRules; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 2000)
    private String description;

    private String category;

    private String channel;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;

    @ManyToOne
    private User customer;

    @ManyToOne
    private User assignedAgent;

    private Integer priorityScore;

    // for repository method: findAllOrderByPriorityScoreDescCreatedAtAsc
    private Instant createdAt = Instant.now();

    // Many-to-many with PriorityRule
    @ManyToMany
    @JoinTable(
            name = "complaint_priority_rule",
            joinColumns = @JoinColumn(name = "complaint_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private Set<PriorityRule> priorityRules = new HashSet<>();

    public Complaint() { }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = Instant.now();
        }
    }

    // ===== enums =====

    public enum Status {
        NEW, IN_PROGRESS, RESOLVED, CLOSED
    }

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public enum Urgency {
        LOW, MEDIUM, HIGH, IMMEDIATE
    }

    // ===== getters / setters =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }

    public Severity getSeverity() { return severity; }
    public void setSeverity(Severity severity) { this.severity = severity; }

    public Urgency getUrgency() { return urgency; }
    public void setUrgency(Urgency urgency) { this.urgency = urgency; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public User getCustomer() { return customer; }
    public void setCustomer(User customer) { this.customer = customer; }

    public User getAssignedAgent() { return assignedAgent; }
    public void setAssignedAgent(User assignedAgent) { this.assignedAgent = assignedAgent; }

    public Integer getPriorityScore() { return priorityScore; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }

    public Instant getCreatedAt() { return

