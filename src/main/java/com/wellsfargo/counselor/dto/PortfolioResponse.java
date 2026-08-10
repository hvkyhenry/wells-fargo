package com.wellsfargo.counselor.dto;

public class PortfolioResponse {

    private long portfolioId;
    private String portfolioName;
    private long clientId;

    public PortfolioResponse() {
    }

    public PortfolioResponse(long portfolioId, String portfolioName, long clientId) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.clientId = clientId;
    }

    // Getters and Setters
    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}