package com.wellsfargo.counselor.dto;

public class PortfolioRequest {

    private String portfolioName;

    public PortfolioRequest() {
    }

    public PortfolioRequest(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }
}