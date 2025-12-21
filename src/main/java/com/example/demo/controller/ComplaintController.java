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
    ComplaintService ser;

    @PostMapping("/post")
    public Complaint sendData(@RequestBody Complaint complaint) {
        return ser.postData(complaint);
    }

    @GetMapping("/get")
    public List<Complaint> getAll() {
        return ser.getAllData();
    }

    @GetMapping("/getid/{id}")
    public Complaint getById(@PathVariable Long id) {
        return ser.getData(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVal(@PathVariable Long id) {
        return ser.deleteData(id);
    }

    @PutMapping("/put/{id}")
    public Complaint updateVal(@PathVariable Long id, @RequestBody Complaint complaint) {
        return ser.updateData(id, complaint);
    }

    @GetMapping("/customer/{customerId}")
    public List<Complaint> getByCustomer(@PathVariable Long customerId) {
        return ser.getComplaintsByCustomer(customerId);
    }

    @GetMapping("/prioritized")
    public List<Complaint> getPrioritized() {
        return ser.getPrioritizedComplaints();
    }
}
