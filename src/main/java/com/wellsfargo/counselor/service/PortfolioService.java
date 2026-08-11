package com.wellsfargo.counselor.service;

import org.springframework.stereotype.Service;
import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.repository.PortfolioRepository;
import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.math.BigDecimal;

@Service
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final ClientRepository clientRepository;

    public PortfolioService(PortfolioRepository portfolioRepository, ClientRepository clientRepository) {
        this.portfolioRepository = portfolioRepository;
        this.clientRepository = clientRepository;
        
    }

    //Create a Portfolio for a Client
    @Transactional
    public Portfolio createPortfolio(Long advisorId, Long clientId, String portfolioName){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        //Validate that the advisor owns teh client
        if (!client.getAdvisor().getAdvisorId().equals(advisorId)) {
            throw new RuntimeException("Advisor does not own the client with id: " + clientId);
        }

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioName(portfolioName);
        portfolio.setClient(client);

        return portfolioRepository.save(portfolio);

    }

    //Get all Portfolios for a Client
    @Transactional(readOnly = true)
    public List<Portfolio> getPortfoliosByClient(Long advisorId, Long clientId){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + clientId));
        //Validate that the advisor owns the client
        if (!client.getAdvisor().getAdvisorId().equals(advisorId)) {
            throw new RuntimeException("Advisor does not own the client with id: " + clientId);
        }

        return portfolioRepository.findByClientClientId(clientId);
    }

    //Calculate the total value of a Portfolio
    @Transactional(readOnly = true)
    public BigDecimal calculatePortfolioValue(Long advisorId, Long portfolioId){
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + portfolioId));
        //Validate that the advisor owns the client associated with the portfolio
        validateAdvisorOwnership(advisorId, portfolio.getClient());

        return portfolio.getPortfolioSecurities().stream()
            .map(holding -> BigDecimal.valueOf(holding.getPurchasePrice())
                    .multiply(BigDecimal.valueOf(holding.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //Delete a Portfolio
    @Transactional
    public void deletePortfolio(Long advisorId, Long portfolioId){
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new RuntimeException("Portfolio not found with id: " + portfolioId));
        //Validate that the advisor owns the client associated with the portfolio
        validateAdvisorOwnership(advisorId, portfolio.getClient());

        portfolioRepository.delete(portfolio);
    }
    
    private void validateAdvisorOwnership(Long advisorId, Client client) {
        if (!client.getAdvisor().getAdvisorId().equals(advisorId)) {
            throw new RuntimeException("Unauthorized access: Client does not belong to the specified advisor");
        }
    }
}
