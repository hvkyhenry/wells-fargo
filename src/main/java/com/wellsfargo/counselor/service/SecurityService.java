package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.repository.SecurityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecurityService {

    private final SecurityRepository securityRepository;

    public SecurityService(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    // 1. ADD NEW SECURITY TO CATALOG
    @Transactional
    public Security createSecurity(Security security) {
        // Business Rule: Ensure symbol/ticker doesn't already exist in catalog
        if (securityRepository.existsByTickerSymbol(security.getTickerSymbol())) {
            throw new IllegalArgumentException("Security with ticker " + security.getTickerSymbol() + " already exists.");
        }
        return securityRepository.save(security);
    }

    // 2. GET ALL SECURITIES IN CATALOG
    @Transactional(readOnly = true)
    public List<Security> getAllSecurities() {
        return securityRepository.findAll();
    }

    // 3. SEARCH SECURITIES BY CATEGORY (e.g., Equity, Bond, ETF)
    @Transactional(readOnly = true)
    public List<Security> getSecuritiesByCategory(String category) {
        return securityRepository.findByCategoryIgnoreCase(category);
    }

    // 4. GET SECURITY BY ID
    @Transactional(readOnly = true)
    public Security getSecurityById(Long securityId) {
        return securityRepository.findById(securityId)
                .orElseThrow(() -> new RuntimeException("Security not found with id: " + securityId));
    }

    // 5. UPDATE SECURITY CATALOG INFO
    @Transactional
    public Security updateSecurity(Long securityId, Security updatedData) {
        Security existing = getSecurityById(securityId);

        existing.setSecurityName(updatedData.getSecurityName());
        existing.setCategory(updatedData.getCategory());
        existing.setTickerSymbol(updatedData.getTickerSymbol());

        return securityRepository.save(existing);
    }

    // 6. DELETE SECURITY FROM CATALOG
    @Transactional
    public void deleteSecurity(Long securityId) {
        Security security = getSecurityById(securityId);
        securityRepository.delete(security);
    }
}