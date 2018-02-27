package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import java.math.BigDecimal;

public class GreatBritainContractCalculatorBuilder extends ContractCalculatorBuilder {

    public GreatBritainContractCalculatorBuilder(CurrencyRatingClient nbpClient) {
        super(nbpClient);
    }

    @Override
    public void buildTax() {
        contractCalculator.setTax(new BigDecimal("0.25"));
    }

    @Override
    public void buildRating() {
        CurrencyRating rating = nbpClient.getRatingFor("gbp");
        contractCalculator.setRating(new BigDecimal(rating.rates.get(0).buyFor));
    }

    @Override
    public void buildLivingCost() {
        contractCalculator.setLivingCost(new BigDecimal("600"));
    }
}
