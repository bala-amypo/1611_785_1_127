package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName; // or name if your test expects "name"

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // must be stored as encoded (hashed)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public enum Role {
        CUSTOMER,
        AGENT,
        ADMIN
    }
}
