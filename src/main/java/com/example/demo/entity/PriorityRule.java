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

    private String name; // rule name
    private String category;
    private boolean active; // true or false
    private int score; // score to add if rule applies
}
