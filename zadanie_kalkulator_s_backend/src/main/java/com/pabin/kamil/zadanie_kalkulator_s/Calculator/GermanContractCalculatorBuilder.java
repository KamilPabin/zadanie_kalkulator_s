package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import java.math.BigDecimal;

public class GermanContractCalculatorBuilder extends ContractCalculatorBuilder {

    @Override
    public void buildTax() {
        contractCalculator.setTax(new BigDecimal("0.2"));
    }

    @Override
    public void buildRating() {
        CurrencyRating rating = currencyRatingClient.getRatingFor("eur");
        contractCalculator.setRating(new BigDecimal(rating.rates.get(0).buyFor));
    }

    @Override
    public void buildLivingCost() {
        contractCalculator.setLivingCost(new BigDecimal("800"));
    }
}
