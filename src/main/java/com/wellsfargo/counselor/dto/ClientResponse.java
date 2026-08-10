package com.wellsfargo.counselor.dto;

public class ClientResponse {

    private long clientId;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private long advisorId;

    public ClientResponse() {
    }

    public ClientResponse(long clientId, String firstName, String lastName, String address, String phoneNumber, String email, long advisorId) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.advisorId = advisorId;
    }

    // Getters and Setters
    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

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

    public long getAdvisorId() {
        return advisorId;
    }

    public void setAdvisorId(long advisorId) {
        this.advisorId = advisorId;
    }
}