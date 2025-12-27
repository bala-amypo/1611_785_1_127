
// package com.example.demo.entity;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     // 👇 REQUIRED to match DB
//     @Column(nullable = false, unique = true)
//     private String username;

//     @Column(nullable = false, unique = true)
//     private String email;

//     private String fullName;

//     private String password;

//     @Enumerated(EnumType.STRING)
//     private Role role = Role.CUSTOMER;

//     public enum Role {
//         CUSTOMER, AGENT
//     }

//     // Constructors
//     public User() {}

//     // Getters & Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getUsername() { return username; }
//     public void setUsername(String username) { this.username = username; }

//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getFullName() { return fullName; }
//     public void setFullName(String fullName) { this.fullName = fullName; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }

//     public Role getRole() { return role; }
//     public void setRole(Role role) { this.role = role; }
// }

package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // REQUIRED (DB column is NOT NULL)
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    private String fullName;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.CUSTOMER;

    public enum Role {
        CUSTOMER, AGENT
    }

    public User() {}

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}

