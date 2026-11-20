package com.pluralsight.dealershipmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SalesContract extends Contract{
    private BigDecimal salesTaxAmount;
    private BigDecimal recordingFee;
    private boolean isFinanced;

    public SalesContract(LocalDate contractDate, Vehicle vehicleSold, String customerEmail, String customerName, BigDecimal salesTaxAmount, BigDecimal recordingFee, boolean isFinanced) {
        super(contractDate, vehicleSold, customerEmail, customerName);
        this.salesTaxAmount = new BigDecimal("0.05");
        this.recordingFee = new BigDecimal("100");;
        this.isFinanced = isFinanced;
    }

    public BigDecimal getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(BigDecimal salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public BigDecimal getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(BigDecimal recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public BigDecimal getProcessingFee(){
//        if(getTotalPrice().compareTo(new BigDecimal("10000")) < 0){
//            return new BigDecimal("295");
//        }else{
//            return new BigDecimal("495");
//        }

        if(getVehicleSold().getPrice().compareTo(new BigDecimal("10000")) < 0){
            return new BigDecimal("295");
        }else{
            return new BigDecimal("495");
        }
    }

    public BigDecimal getTotalPrice(){
        getVehicleSold().getPrice();
        return null;
    }

    public BigDecimal getMonthlyPayment(){
        return null;
    }
}
