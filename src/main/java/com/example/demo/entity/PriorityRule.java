package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "priority_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleName;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private Integer weight; // positively influences computed priorityScore

    @Column(nullable = false)
    private boolean active;

   

    @PrePersist
    protected void onCreate() {
        this.active = true; // default active = true
    }
}
