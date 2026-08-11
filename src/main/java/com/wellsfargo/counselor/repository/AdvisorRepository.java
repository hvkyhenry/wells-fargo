package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    
    // Custom query method to check if an email already exists
    boolean existsByEmail(String email);
    
    // Optional lookup by email for authentication workflows
    Optional<Advisor> findByEmail(String email);
}