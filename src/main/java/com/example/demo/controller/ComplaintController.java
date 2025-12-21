package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    ComplaintService service;

    @PostMapping("/post")
    public Complaint postComplaint(@RequestBody Complaint complaint) {
        return service.postData(complaint);
    }

    @GetMapping("/get")
    public List<Complaint> getAllComplaints() {
        return service.getAllData();
    }

    @GetMapping("/get/{id}")
    public Complaint getComplaintById(@PathVariable Long id) {
        return service.getDataById(id);
    }

    @PutMapping("/put/{id}")
    public Complaint updateComplaint(@PathVariable Long id, @RequestBody Complaint complaint) {
        return service.updateData(id, complaint);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteComplaint(@PathVariable Long id) {
        return service.deleteData(id);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritized() {
        return service.getPrioritizedComplaints();
    }
}
