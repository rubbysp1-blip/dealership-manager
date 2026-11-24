package com.pluralsight.dealershipmanager.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalesContractTest {

    @Test
    public void getTotalPrice_shouldReturn_SalesMonthlyPayment(){
        //arrange
        Vehicle vehicleSold = new Vehicle(new BigDecimal("995.00"), 123123, "Blue", "Car", "Skyline", "Nissan", 1990, 123456);
        SalesContract contract = new SalesContract(LocalDate.now(), vehicleSold, "123@gmail.com", "Sandy", false);
        //act
        BigDecimal totalPrice = contract.getTotalPrice();
        //assert
        assertEquals(new BigDecimal("1439.75"), totalPrice);
    }

    @Test
    public void getMonthlyPayment_shouldReturn_SalesMonthlyPayment(){
        //arrange
        Vehicle vehicleSold = new Vehicle(new BigDecimal("995.00"), 123123, "Blue", "Car", "Skyline", "Nissan", 1990, 123456);
        SalesContract contract = new SalesContract(LocalDate.now(), vehicleSold, "123@gmail.com", "Sandy", false);
        //act
        BigDecimal monthlyPayment = contract.getMonthlyPayment();
        //assert
        assertEquals(new BigDecimal("0"), monthlyPayment);
    }
}