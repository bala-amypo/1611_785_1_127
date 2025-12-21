package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    // get complaints by customerId
    List<Complaint> findByCustomerId(Long customerId);

    // get all complaints ordered by priorityScore desc and createdAt asc
    List<Complaint> findAllByOrderByPriorityScoreDescCreatedAtAsc();
}
