package com.wellsfargo.counselor.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Security {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long securityId;

    @Column(nullable = false)
    private String securityName;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, unique = true)
    private String tickerSymbol;

    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL)
    private List<PortfolioSecurity> portfolioSecurities;

    protected Security() {
        // Default constructor for JPA
    }

    public Security(String securityName, String category, String tickerSymbol){
        this.securityName= securityName;
        this.category = category;
        this.tickerSymbol = tickerSymbol;
    }

    // Getters and Setters
    public long getSecurityId() {
        return securityId;
    }
    public String getSecurityName() {
        return securityName;
    }
    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getTickerSymbol() {
        return tickerSymbol;
    }
    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }

    public List<PortfolioSecurity> getPortfolioSecurities() {
        return portfolioSecurities;
    }

    public void setPortfolioSecurities(List<PortfolioSecurity> portfolioSecurities) {
        this.portfolioSecurities = portfolioSecurities;
    }
}
