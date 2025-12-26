package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @PostMapping("/submit")
    public String submit(@RequestBody ComplaintRequest req) {
        return "submitted";
    }

    @GetMapping("/prioritized")
    public String prioritized() {
        return "list";
    }
}
