package com.wellsfargo.counselor.dto;

public class SecurityRequest {

    private String securityName;
    private String category;
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