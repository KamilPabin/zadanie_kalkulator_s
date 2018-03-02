package com.pabin.kamil.zadanie_kalkulator_s.calculator;

import java.math.BigDecimal;

public class ContractCalculator {
    private BigDecimal tax = new BigDecimal("1");
    private BigDecimal livingCost = new BigDecimal("0");
    private BigDecimal rating = new BigDecimal("1");
    private BigDecimal numberOfWorkingDays = new BigDecimal("22");
    private BigDecimal grossMonthySalary = new BigDecimal("0");
    private BigDecimal monthyTax = new BigDecimal("0");

    public BigDecimal calculateNetMonthlySalary(BigDecimal dailySalary) {
        grossMonthySalary = dailySalary.multiply(numberOfWorkingDays);
        monthyTax = grossMonthySalary.multiply(tax).add(livingCost);
        return grossMonthySalary.subtract(monthyTax).multiply(rating);
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public void setLivingCost(BigDecimal livingCost) {
        this.livingCost = livingCost;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}
