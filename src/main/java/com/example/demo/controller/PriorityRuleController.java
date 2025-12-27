// package com.example.demo.controller;

// import com.example.demo.entity.Complaint;
// import com.example.demo.entity.PriorityRule;
// import com.example.demo.service.PriorityRuleService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/priority-rules")
// public class PriorityRuleController {

//     private final PriorityRuleService priorityRuleService;

//     public PriorityRuleController(PriorityRuleService priorityRuleService) {
//         this.priorityRuleService = priorityRuleService;
//     }

//     // 👉 Get all active priority rules
//     @GetMapping("/active")
//     public ResponseEntity<List<PriorityRule>> getActiveRules() {
//         return ResponseEntity.ok(
//                 priorityRuleService.getActiveRules()
//         );
//     }

//     // 👉 Compute priority score for a complaint (optional utility endpoint)
//     @PostMapping("/compute")
//     public ResponseEntity<Integer> computePriorityScore(
//             @RequestBody Complaint complaint
//     ) {
//         int score = priorityRuleService.computePriorityScore(complaint);
//         return ResponseEntity.ok(score);
//     }
// }


package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.service.PriorityRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/priority-rules")
public class PriorityRuleController {

    private final PriorityRuleService priorityRuleService;

    public PriorityRuleController(PriorityRuleService priorityRuleService) {
        this.priorityRuleService = priorityRuleService;
    }

    // ✅ CREATE priority rule
    @PostMapping
    public ResponseEntity<PriorityRule> createRule(
            @RequestBody PriorityRule rule
    ) {
        return ResponseEntity.ok(priorityRuleService.save(rule));
    }

    // ✅ GET active rules
    @GetMapping("/active")
    public ResponseEntity<List<PriorityRule>> getActiveRules() {
        return ResponseEntity.ok(priorityRuleService.getActiveRules());
    }

    // ✅ COMPUTE score
    @PostMapping("/compute")
    public ResponseEntity<Integer> computePriorityScore(
            @RequestBody com.example.demo.entity.Complaint complaint
    ) {
        int score = priorityRuleService.computePriorityScore(complaint);
        return ResponseEntity.ok(score);
    }
}
