package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.PortfolioSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wellsfargo.counselor.entity.Portfolio;
import java.util.List;

@Repository
public interface PortfolioSecurityRepository extends JpaRepository<PortfolioSecurity, Long> {
    List<PortfolioSecurity> findByPortfolio(Portfolio portfolio);
}
