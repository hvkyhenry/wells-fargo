package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Advisor;
import com.wellsfargo.counselor.repository.AdvisorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdvisorService {

    private final AdvisorRepository advisorRepository;

    public AdvisorService(AdvisorRepository advisorRepository) {
        this.advisorRepository = advisorRepository;
    }

    // 1. CREATE / REGISTER ADVISOR
    @Transactional
    public Advisor createAdvisor(Advisor advisor) {
        // Business Rule: Ensure email address is unique across all advisors
        if (advisorRepository.existsByEmail(advisor.getEmail())) {
            throw new IllegalArgumentException("Advisor with email " + advisor.getEmail() + " already exists.");
        }
        return advisorRepository.save(advisor);
    }

    // 2. GET ALL ADVISORS
    @Transactional(readOnly = true)
    public List<Advisor> getAllAdvisors() {
        return advisorRepository.findAll();
    }

    // 3. GET ADVISOR BY ID
    @Transactional(readOnly = true)
    public Advisor getAdvisorById(Long advisorId) {
        return advisorRepository.findById(advisorId)
                .orElseThrow(() -> new RuntimeException("Advisor not found with id: " + advisorId));
    }

    // 4. UPDATE ADVISOR PROFILE
    @Transactional
    public Advisor updateAdvisor(Long advisorId, Advisor updatedData) {
        Advisor existingAdvisor = getAdvisorById(advisorId);

        existingAdvisor.setFirstName(updatedData.getFirstName());
        existingAdvisor.setLastName(updatedData.getLastName());
        existingAdvisor.setPhone(updatedData.getPhone());
        existingAdvisor.setEmail(updatedData.getEmail());

        return advisorRepository.save(existingAdvisor);
    }

    // 5. DELETE ADVISOR
    @Transactional
    public void deleteAdvisor(Long advisorId) {
        Advisor advisor = getAdvisorById(advisorId);
        
        // Business Rule: Prevent deletion if advisor still manages active clients
        if (advisor.getClients() != null && !advisor.getClients().isEmpty()) {
            throw new IllegalStateException("Cannot delete advisor who currently manages active clients. Reassign clients first.");
        }

        advisorRepository.delete(advisor);
    }
}