package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import org.springframework.stereotype.Component;

@Component
public abstract class ContractCalculatorBuilder {


    protected CurrencyRatingClient nbpClient;

    protected ContractCalculator contractCalculator;

    public ContractCalculatorBuilder(CurrencyRatingClient nbpClient) {
        this.nbpClient = nbpClient;
    }

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
