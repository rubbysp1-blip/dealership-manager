package com.pluralsight.dealershipmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LeaseContract extends Contract{
    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;

    public LeaseContract(LocalDate contractDate, Vehicle vehicleSold, String customerEmail, String customerName, BigDecimal expectedEndingValue, BigDecimal leaseFee) {
        super(contractDate, vehicleSold, customerEmail, customerName);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public BigDecimal getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(BigDecimal expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public BigDecimal getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(BigDecimal leaseFee) {
        this.leaseFee = leaseFee;
    }
    @Override
    public BigDecimal getTotalPrice(){

        return null;
    }
    @Override
    public BigDecimal getMonthlyPayment(){
        return null;
    }
}
