package com.wellsfargo.counselor.dto;

import jakarta.validation.constraints.*;

public class ClientRequest {

    @NotBlank(message="First name is required")
    @Size(min=2, max=50, message="First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message="Last name is required")
    @Size(min=2, max=50, message="Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message="Address is required")
    private String address;

    @NotBlank(message="Phone number is required")
    @Pattern(
        regexp = "^\\+?[0-9. ()-]{7,25}$",
        message = "Phone number must be valid and contain between 7 and 25 digits"
    )
    private String phoneNumber;

    @NotBlank(message="Email is required")
    @Email(message="Email should be valid")
    private String email;

    public ClientRequest() {
    }

    public ClientRequest(String firstName, String lastName, String address, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}