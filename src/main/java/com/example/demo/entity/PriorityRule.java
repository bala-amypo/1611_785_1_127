package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data               // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor   // Generates a no-args constructor
@AllArgsConstructor  // Generates an all-args constructor
public class PriorityRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int priority;
}
