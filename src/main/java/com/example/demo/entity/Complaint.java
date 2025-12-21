// package com.example.demo.entity;

// import java.time.LocalDateTime;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.Setter;

// @Entity
// @Table(name = "complaints")
// @Getter
// @Setter
// public class Complaint {

//     public enum Status {
//         NEW, OPEN, IN_PROGRESS, RESOLVED
//     }

//     public enum Severity {
//         LOW, MEDIUM, HIGH, CRITICAL
//     }

//     public enum Urgency {
//         LOW, MEDIUM, HIGH, IMMEDIATE
//     }

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String title;
//     private String description;
//     private String category;
//     private String channel;
//     private Integer priorityScore;
//     private LocalDateTime createdAt;

//     @Enumerated(EnumType.STRING)
//     private Status status;

//     @Enumerated(EnumType.STRING)
//     private Severity severity;

//     @Enumerated(EnumType.STRING)
//     private Urgency urgency;

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         this.status = Status.NEW;
//     }
// }
package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "complaints")
@Getter
@Setter
public class Complaint {

    public enum Severity { LOW, MEDIUM, HIGH, CRITICAL }
    public enum Urgency { LOW, MEDIUM, HIGH, IMMEDIATE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private Urgency urgency;

    private int priorityScore;
}
