package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.service.SecurityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/securities")
public class SecurityController {

    private final SecurityService securityService;

    public SecurityController(SecurityService securityService) {
        this.securityService = securityService;
    }

    // CREATE: Add a new security to the catalog
    @PostMapping
    public ResponseEntity<Security> createSecurity(@Valid @RequestBody Security security) {
        Security created = securityService.createSecurity(security);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // READ: Get all securities in catalog
    @GetMapping
    public ResponseEntity<List<Security>> getAllSecurities() {
        return ResponseEntity.ok(securityService.getAllSecurities());
    }

    // READ: Search securities by category (e.g., /api/securities/category/Equity)
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Security>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(securityService.getSecuritiesByCategory(category));
    }

    // UPDATE: Update security metadata
    @PutMapping("/{securityId}")
    public ResponseEntity<Security> updateSecurity(@PathVariable Long securityId,
                                                   @Valid @RequestBody Security updatedData) {
        return ResponseEntity.ok(securityService.updateSecurity(securityId, updatedData));
    }

    // DELETE: Remove security from catalog
    @DeleteMapping("/{securityId}")
    public ResponseEntity<Void> deleteSecurity(@PathVariable Long securityId) {
        securityService.deleteSecurity(securityId);
        return ResponseEntity.noContent().build();
    }
}