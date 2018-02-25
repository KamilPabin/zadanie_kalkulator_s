package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ContractCalculatorBuilder {
    protected ContractCalculator contractCalculator;

    @Autowired
    protected CurrencyRatingClient currencyRatingClient;

    public ContractCalculator getContractCalculator() {
        return contractCalculator;
    }

    public void createNewContractCalculator() {
        contractCalculator = new ContractCalculator();
    }

    public abstract void buildTax();

    public abstract void buildRating();

    public abstract void buildLivingCost();
}
