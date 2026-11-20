package com.pluralsight.dealershipmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Contract {
    private LocalDate contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract(LocalDate contractDate, Vehicle vehicleSold, String customerEmail, String customerName) {
        this.contractDate = contractDate;
        this.vehicleSold = vehicleSold;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract BigDecimal getTotalPrice();

    public abstract BigDecimal getMonthlyPayment();
}
