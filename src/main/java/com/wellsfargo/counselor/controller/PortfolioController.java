package com.wellsfargo.counselor.controller;

import com.wellsfargo.counselor.entity.Portfolio;
import com.wellsfargo.counselor.service.PortfolioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/advisors/{advisorId}/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // CREATE: Add a portfolio for a specific client
    @PostMapping("/client/{clientId}")
    public ResponseEntity<Portfolio> createPortfolio(@PathVariable Long advisorId,
                                                     @PathVariable Long clientId,
                                                     @RequestParam String portfolioName) {
        Portfolio portfolio = portfolioService.createPortfolio(advisorId, clientId, portfolioName);
        return new ResponseEntity<>(portfolio, HttpStatus.CREATED);
    }

    // READ: Get all portfolios owned by a specific client
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Portfolio>> getPortfoliosByClient(@PathVariable Long advisorId,
                                                                 @PathVariable Long clientId) {
        return ResponseEntity.ok(portfolioService.getPortfoliosByClient(advisorId, clientId));
    }

    // READ: Calculate total dollar valuation of a portfolio
    @GetMapping("/{portfolioId}/valuation")
    public ResponseEntity<BigDecimal> getPortfolioValue(@PathVariable Long advisorId,
                                                        @PathVariable Long portfolioId) {
        BigDecimal totalValue = portfolioService.calculatePortfolioValue(advisorId, portfolioId);
        return ResponseEntity.ok(totalValue);
    }

    // DELETE: Remove an empty portfolio
    @DeleteMapping("/{portfolioId}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long advisorId,
                                                @PathVariable Long portfolioId) {
        portfolioService.deletePortfolio(advisorId, portfolioId);
        return ResponseEntity.noContent().build();
    }
}