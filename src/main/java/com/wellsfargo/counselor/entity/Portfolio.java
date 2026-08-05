package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
public class Portfolio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long portfolioId;

    @Column(nullable = false)
    private String portfolioName;

    // Many portfolios can belong to one client
    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    // Initialized to an empty list to prevent null pointers
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioSecurity> portfolioSecurities = new ArrayList<>();
    public Portfolio() {
        // Default constructor for JPA
    }

    public Portfolio(String portfolioName, Client client){
        this.portfolioName = portfolioName;
        this.client = client;
    }

    // Getters and Setters
    public long getPortfolioId() {
        return portfolioId;
    }
    public String getPortfolioName() {
        return portfolioName;
    }
    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public List<PortfolioSecurity> getPortfolioSecurities() {
        return portfolioSecurities;
    }

    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
