// package com.example.demo.repository;

// import com.example.demo.entity.Complaint;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import java.util.List;

// public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
//     List<Complaint> findByCustomer(com.example.demo.entity.User customer);
    
//     @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.createdAt ASC")
//     List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
// }

// src/main/java/com/example/demo/repository/ComplaintRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByCustomer(User customer);

    // Correct Spring Data naming for ORDER BY priorityScore DESC, createdAt ASC
    List<Complaint> findAllByOrderByPriorityScoreDescCreatedAtAsc();
}
