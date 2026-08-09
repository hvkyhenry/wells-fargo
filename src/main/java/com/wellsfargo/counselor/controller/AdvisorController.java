package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.service.AdvisorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advisors")
public class AdvisorController {

    private final AdvisorService advisorService;

    // Dependency Injection: Service is injected into Controller
    public AdvisorController(AdvisorService advisorService) {
        this.advisorService = advisorService;
    }

    // CREATE: Register a new advisor -> HTTP 201 Created
    @PostMapping
    public ResponseEntity<Advisor> createAdvisor(@RequestBody Advisor advisor) {
        Advisor created = advisorService.createAdvisor(advisor);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ: Get all advisors -> HTTP 200 OK
    @GetMapping
    public ResponseEntity<List<Advisor>> getAllAdvisors() {
        return ResponseEntity.ok(advisorService.getAllAdvisors());
    }

    // READ: Get advisor by ID -> HTTP 200 OK
    @GetMapping("/{advisorId}")
    public ResponseEntity<Advisor> getAdvisorById(@PathVariable Long advisorId) {
        return ResponseEntity.ok(advisorService.getAdvisorById(advisorId));
    }

    // UPDATE: Update advisor profile -> HTTP 200 OK
    @PutMapping("/{advisorId}")
    public ResponseEntity<Advisor> updateAdvisor(@PathVariable Long advisorId, 
                                                @RequestBody Advisor updatedData) {
        Advisor updated = advisorService.updateAdvisor(advisorId, updatedData);
        return ResponseEntity.ok(updated);
    }

    // DELETE: Remove advisor -> HTTP 204 No Content
    @DeleteMapping("/{advisorId}")
    public ResponseEntity<Void> deleteAdvisor(@PathVariable Long advisorId) {
        advisorService.deleteAdvisor(advisorId);
        return ResponseEntity.noContent().build();
    }
}