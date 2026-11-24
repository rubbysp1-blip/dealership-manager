package com.pluralsight.dealershipmanager.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {

    @Test
    public void getTotalPrice_shouldReturn_LeaseMonthlyPayment(){
        //arrange
        Vehicle vehicleSold = new Vehicle(new BigDecimal("31995.00"), 123123, "Blue", "Car", "Skyline", "Nissan", 1990, 123456);
        LeaseContract contract = new LeaseContract(LocalDate.now(), vehicleSold, "123@gmail.com", "Sandy");
        //act
        BigDecimal totalPrice = contract.getTotalPrice();
        //assert
        assertEquals(new BigDecimal("18237.15"), totalPrice);
    }

    @Test
    public void getMonthlyPayment_shouldReturn_LeaseMonthlyPayment(){
        //arrange
        Vehicle vehicleSold = new Vehicle(new BigDecimal("31995.00"), 123123, "Blue", "Car", "Skyline", "Nissan", 1990, 123456);
        LeaseContract contract = new LeaseContract(LocalDate.now(), vehicleSold, "123@gmail.com", "Sandy");
        //act
        BigDecimal monthlyPayment = contract.getMonthlyPayment();
        //assert
        assertEquals(new BigDecimal("538.43"), monthlyPayment);
    }
}