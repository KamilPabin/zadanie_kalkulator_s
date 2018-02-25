package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import org.springframework.stereotype.Service;

@Service
public class Accountant {

    private ContractCalculatorBuilder builder;

    public void setCalculatorBuilder(ContractCalculatorBuilder builder) {
        this.builder = builder;
    }

    public ContractCalculator getContractCalculator() {
        return builder.getContractCalculator();
    }

    public void constructContractCalculator() {
        builder.createNewContractCalculator();
        builder.buildLivingCost();
        builder.buildRating();
        builder.buildTax();
    }
}
