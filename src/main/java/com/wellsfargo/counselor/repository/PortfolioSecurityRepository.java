package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.PortfolioSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioSecurityRepository extends JpaRepository<PortfolioSecurity, Long> {
    
}
