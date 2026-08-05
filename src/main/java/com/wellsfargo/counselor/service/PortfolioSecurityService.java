package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.entity.PortfolioSecurity;
import com.wellsfargo.counselor.entity.Security;
import com.wellsfargo.counselor.repository.PortfolioRepository;
import com.wellsfargo.counselor.repository.PortfolioSecurityRepository;
import com.wellsfargo.counselor.repository.SecurityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PortfolioSecurityService {
    
    private final PortfolioSecurityRepository portfolioSecurityRepository;
    private final PortfolioRepository portfolioRepository;
    private final SecurityRepository securityRepository;

    public PortfolioSecurityService(PortfolioSecurityRepository portfolioSecurityRepository, PortfolioRepository portfolioRepository, SecurityRepository securityRepository) {
        this.portfolioSecurityRepository = portfolioSecurityRepository;
        this.portfolioRepository = portfolioRepository;
        this.securityRepository = securityRepository;
    }

    //Add a Security to a Portfolio
    @Transactional
    public PortfolioSecurity addSecurityToPortfolio(Long advisorId, Long portfolioId, Long securityId, int quantity, LocalDate purchaseDate, double purchasePrice) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + portfolioId));
        Security security = securityRepository.findById(securityId)
                .orElseThrow(() -> new RuntimeException("Security not found with id: " + securityId));

        //Validate advisor ownership of the portfolio
        validateAdvisorOwnership(advisorId, portfolio);

        // Validate inputs
        validateHoldingData(purchasePrice, quantity, purchaseDate);

        //Create and persist holding
        PortfolioSecurity portfolioSecurity = new PortfolioSecurity(portfolio, security, purchaseDate, purchasePrice, quantity);
        return portfolioSecurityRepository.save(portfolioSecurity);
    }

    // Get all holdings in a portfolio
    @Transactional(readOnly = true)
    public List<PortfolioSecurity> getHoldingsInPortfolio(Long advisorId, Long portfolioId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + portfolioId));

        //Validate advisor ownership of the portfolio
        validateAdvisorOwnership(advisorId, portfolio);

        return portfolioSecurityRepository.findByPortfolio(portfolio);
    }

    // Update holdings and price
    @Transactional
    public PortfolioSecurity updateHolding(Long advisorId, Long porSecId, int newQuantity, double newPrice){
        PortfolioSecurity portfolioSecurity = portfolioSecurityRepository.findById(porSecId)
                .orElseThrow(() -> new RuntimeException("PortfolioSecurity not found with id: " + porSecId));

        //Validate advisor ownership of the portfolio
        validateAdvisorOwnership(advisorId, portfolioSecurity.getPortfolio());

        // Validate inputs
        validateHoldingData(newPrice, newQuantity, portfolioSecurity.getPurchaseDate());

        // Update and persist holding
        portfolioSecurity.setQuantity(newQuantity);
        portfolioSecurity.setPurchasePrice(newPrice);
        return portfolioSecurityRepository.save(portfolioSecurity);
    }

    // Delete a holding from a portfolio
    @Transactional
    public void deleteHolding(Long advisorId, Long porSecId){
        PortfolioSecurity portfolioSecurity = portfolioSecurityRepository.findById(porSecId)
                .orElseThrow(() -> new RuntimeException("PortfolioSecurity not found with id: " + porSecId));

        //Validate advisor ownership of the portfolio
        validateAdvisorOwnership(advisorId, portfolioSecurity.getPortfolio());

        portfolioSecurityRepository.delete(portfolioSecurity);
    }


    // Helper method to validate advisor ownership of a portfolio
    private void validateAdvisorOwnership(Long advisorId, Portfolio portfolio) {
        if (!portfolio.getClient().getAdvisor().getAdvisorId().equals(advisorId)) {
            throw new RuntimeException("Advisor does not own the portfolio with id: " + portfolio.getPortfolioId());
        }
    }

    private void validateHoldingData(double purchasePrice, int quantity, LocalDate purchaseDate) {
        if (purchasePrice <= 0) {
            throw new IllegalArgumentException("Purchase price must be greater than zero.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (purchaseDate != null && purchaseDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Purchase date cannot be in the future.");
        }
    }
}
