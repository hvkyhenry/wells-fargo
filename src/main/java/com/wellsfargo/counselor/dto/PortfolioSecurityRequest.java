package com.wellsfargo.counselor.dto;

import java.time.LocalDate;

public class PortfolioSecurityRequest {

    private long securityId;
    private LocalDate purchaseDate;
    private double purchasePrice;
    private int quantity;

    public PortfolioSecurityRequest() {
    }

    public PortfolioSecurityRequest(long securityId, LocalDate purchaseDate, double purchasePrice, int quantity) {
        this.securityId = securityId;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    // Getters and Setters
    public long getSecurityId() {
        return securityId;
    }

    public void setSecurityId(long securityId) {
        this.securityId = securityId;
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