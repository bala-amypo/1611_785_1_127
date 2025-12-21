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
    private LocalDateTime submittedOn; 

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Urgency urgency;

    

    @PrePersist
    protected void onCreate() {
        this.submittedOn = LocalDateTime.now();
        this.status = Status.NEW; 
    }


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
