package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PortfolioSecurity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long porSecId;


    @ManyToOne
    @JoinColumn(name = "portfolioId", nullable = false)
    private Portfolio portfolio;
    
    @ManyToOne
    @JoinColumn(name = "securityId", nullable = false)
    private Security security;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    @Column(nullable = false)
    private double purchasePrice;

    @Column(nullable = false)
    private int quantity;

    protected PortfolioSecurity() {
        // Default constructor for JPA
    }

    public PortfolioSecurity(Portfolio portfolio, Security security, LocalDate purchaseDate, double purchasePrice, int quantity) {
        this.portfolio = portfolio;
        this.security = security;
        this.purchaseDate = purchaseDate;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }

    // Getters and Setters
    public long getPorSecId() {
        return porSecId;
    }
    public Portfolio getPortfolio() {
        return portfolio;
    }
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    public Security getSecurity() {
        return security;
    }
    public void setSecurity(Security security) {
        this.security = security;
    }
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public double getPurchasePrice() {
        return purchasePrice;
    }
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
