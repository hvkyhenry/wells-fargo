package com.wellsfargo.counselor.dto;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

public class PortfolioRequest {

    @NotBlank(message="Portfolio name is required")
    @Size(min=2, max=100, message="Portfolio name must be between 2 and 100 characters")
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