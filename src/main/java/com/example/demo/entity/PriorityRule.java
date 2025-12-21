package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "priority_rules")
@Getter
@Setter
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;        // e.g., Complaint category
    private int weight;             // priority weight
    private boolean active;         // is rule active

}
