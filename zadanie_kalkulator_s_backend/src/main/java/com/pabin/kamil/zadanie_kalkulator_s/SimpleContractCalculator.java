package com.pabin.kamil.zadanie_kalkulator_s;

public class SimpleContractCalculator implements ContractCalculator {

    private double currencyRate;
    private double tax;
    private double livingCost;
    private int numberOfWorkingDays = 22;

    public SimpleContractCalculator(double currencyRate, double tax, double livingCost) {
        this.currencyRate = currencyRate;
        this.tax = tax;
        this.livingCost = livingCost;
    }

    @Override
    public double calculate(double dailySalary) {
        double monthySalary = numberOfWorkingDays * dailySalary * tax - livingCost;
        return monthySalary*currencyRate;
    }

}
