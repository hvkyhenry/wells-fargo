package com.wellsfargo.counselor.dto;

public class SecurityResponse {

    private long securityId;
    private String securityName;
    private String category;
    private String tickerSymbol;

    public SecurityResponse() {
    }

    public SecurityResponse(long securityId, String securityName, String category, String tickerSymbol) {
        this.securityId = securityId;
        this.securityName = securityName;
        this.category = category;
        this.tickerSymbol = tickerSymbol;
    }

    // Getters and Setters
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