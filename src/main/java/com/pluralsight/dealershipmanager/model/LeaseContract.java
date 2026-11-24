package com.pluralsight.dealershipmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import static com.pluralsight.dealershipmanager.model.LoanCalculator.calculateMonthlyPayment;

public class LeaseContract extends Contract{
    private BigDecimal expectedEndingValue;
    private BigDecimal leaseFee;

    public LeaseContract(LocalDate contractDate, Vehicle vehicleSold, String customerEmail, String customerName) {
        super(contractDate, vehicleSold, customerEmail, customerName);
        this.expectedEndingValue = getVehicleSold().getPrice().multiply(new BigDecimal(".50"));
        this.leaseFee = getVehicleSold().getPrice().multiply(new BigDecimal(".07"));
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
        return getExpectedEndingValue().add(getLeaseFee()).setScale(2, RoundingMode.HALF_DOWN);
    }
    @Override
    public BigDecimal getMonthlyPayment(){
        //return calculateMonthlyPayment(getVehicleSold().getPrice(), new BigDecimal("4.0"), 36);
        return calculateMonthlyPayment(getTotalPrice(), new BigDecimal("4.0"), 36);
    }
}
