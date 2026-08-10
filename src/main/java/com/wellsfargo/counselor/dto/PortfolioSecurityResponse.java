package com.wellsfargo.counselor.dto;

import java.time.LocalDate;

public class PortfolioSecurityResponse {

    private long porSecId;
    private long portfolioId;
    private long securityId;
    private String securityName;
    private String tickerSymbol;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private int quantity;

    public PortfolioSecurityResponse() {
    }

    public PortfolioSecurityResponse(long porSecId, long portfolioId, long securityId, String securityName, String tickerSymbol, LocalDate purchaseDate, double purchasePrice, int quantity) {
        this.porSecId = porSecId;
        this.portfolioId = portfolioId;
        this.securityId = securityId;
        this.securityName = securityName;
        this.tickerSymbol = tickerSymbol;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    // Getters and Setters
    public long getPorSecId() {
        return porSecId;
    }

    public void setPorSecId(long porSecId) {
        this.porSecId = porSecId;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public long getSecurityId() {
        return securityId;
    }

    public void setSecurityId(long securityId) {
        this.securityId = securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
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