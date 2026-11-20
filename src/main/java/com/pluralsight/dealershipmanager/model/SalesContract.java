package com.pluralsight.dealershipmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.pluralsight.dealershipmanager.model.LoanCalculator.calculateMonthlyPayment;

public class SalesContract extends Contract{
    private BigDecimal salesTaxAmount;
    private BigDecimal recordingFee;
    private boolean isFinanced;

    public SalesContract(LocalDate contractDate, Vehicle vehicleSold, String customerEmail, String customerName, BigDecimal salesTaxAmount, BigDecimal recordingFee, boolean isFinanced) {
        super(contractDate, vehicleSold, customerEmail, customerName);
        this.salesTaxAmount = getVehicleSold().getPrice().multiply(new BigDecimal("0.05"));
        this.recordingFee = new BigDecimal("100");
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
    @Override
    public BigDecimal getTotalPrice(){

        return getVehicleSold().getPrice().add(getSalesTaxAmount()).add(getRecordingFee()).add(getProcessingFee());
    }
    @Override
    public BigDecimal getMonthlyPayment(){
        if(!isFinanced){
            return BigDecimal.ZERO;
        }else{
            boolean isAbovePriceThreshold = getVehicleSold().getPrice().compareTo(new BigDecimal("10000")) >= 0;
            if(isAbovePriceThreshold){
                return calculateMonthlyPayment(getVehicleSold().getPrice(), new BigDecimal(".0425"), 48);
            }else{
                return calculateMonthlyPayment(getVehicleSold().getPrice(), new BigDecimal(".0525"), 24);
            }
        }

    }
}
