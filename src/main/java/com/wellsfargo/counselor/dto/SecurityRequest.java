package com.wellsfargo.counselor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

public class SecurityRequest {

    @NotBlank(message="Security name is required")
    @Size(min=2, max=100, message="Security name must be between 2 and 100 characters")
    private String securityName;

    @NotBlank(message="Category is required")
    @Size(min=2, max=50, message="Category must be between 2 and 50 characters")
    private String category;

    @NotBlank(message="Ticker symbol is required")
    @Pattern(
        regexp = "^[A-Z0-9.]{1,10}$",
        message = "Ticker symbol must be valid and contain between 1 and 10 uppercase letters or numbers (e.g. AAPL, MSFT, GOOGL)"
    )
    private String tickerSymbol;

    public SecurityRequest() {
    }

    public SecurityRequest(String securityName, String category, String tickerSymbol) {
        this.securityName = securityName;
        this.category = category;
        this.tickerSymbol = tickerSymbol;
    }

    // Getters and Setters
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
}