package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository repo;

    @Override
    public Complaint postData(Complaint complaint) {
        return repo.save(complaint);
    }

    @Override
    public List<Complaint> getAllData() {
        return repo.findAll();
    }

    @Override
    public Complaint getData(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Complaint updateData(Long id, Complaint complaint) {
        Complaint existing = repo.findById(id).orElse(null);
        if (existing != null) {
            complaint.setId(id);
            return repo.save(complaint);
        }
        return null;
    }

    @Override
    public String deleteData(Long id) {
        repo.deleteById(id);
        return "Complaint deleted successfully";
    }
}
