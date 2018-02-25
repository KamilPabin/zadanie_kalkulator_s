package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import java.math.BigDecimal;

public class PolandContractCalculatorBuilder extends ContractCalculatorBuilder {

    @Override
    public void buildTax() {
        contractCalculator.setTax(new BigDecimal("0.19"));
    }

    @Override
    public void buildRating() {
        contractCalculator.setRating(new BigDecimal("1"));
    }

    @Override
    public void buildLivingCost() {
        contractCalculator.setLivingCost(new BigDecimal("1200"));
    }
}
