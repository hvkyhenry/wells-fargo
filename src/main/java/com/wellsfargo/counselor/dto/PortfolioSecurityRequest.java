package com.wellsfargo.counselor.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class PortfolioSecurityRequest {

    @NotNull(message="Security ID is required")
    @Positive(message="Security ID must be a positive number")
    private long securityId;

    @NotNull(message="Purchase date is required")
    @PastOrPresent(message="Purchase date cannot be in the future")
    private LocalDate purchaseDate;

    @NotNull(message="Purchase price is required")
    @Positive(message="Purchase price must be a positive number")
    private double purchasePrice;

    @NotNull(message="Quantity is required")
    @Min(value=1, message="Quantity must be at least 1")
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