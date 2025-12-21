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

    @PostMapping("/cpost")
    public Complaint csendData(@RequestBody Complaint complaint) {
        return ser.cpostData(complaint);
    }

    @GetMapping("/cget")
    public List<Complaint> cgetAll() {
        return ser.getAllData();
    }

    @GetMapping("/cgetid/{id}")
    public Complaint cgetById(@PathVariable Long id) {
        return ser.getData(id);
    }

    @DeleteMapping("/cdelete/{id}")
    public String cdeleteVal(@PathVariable Long id) {
        return ser.deleteData(id);
    }

    @PutMapping("/cput/{id}")
    public Complaint cupdateVal(@PathVariable Long id, @RequestBody Complaint complaint) {
        return ser.updateData(id, complaint);
    }

    @GetMapping("/ccustomer/{customerId}")
    public List<Complaint> cgetByCustomer(@PathVariable Long customerId) {
        return ser.getComplaintsByCustomer(customerId);
    }

    @GetMapping("/cprioritized")
    public List<Complaint> cgetPrioritized() {
        return ser.getPrioritizedComplaints();
    }
}
