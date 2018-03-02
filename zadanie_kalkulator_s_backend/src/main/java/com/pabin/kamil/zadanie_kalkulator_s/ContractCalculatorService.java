package com.pabin.kamil.zadanie_kalkulator_s;

import com.pabin.kamil.zadanie_kalkulator_s.calculator.*;
import com.pabin.kamil.zadanie_kalkulator_s.client.CurrencyRatingClient;
import com.pabin.kamil.zadanie_kalkulator_s.calculator.exceptions.UnsupportedCountryException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContractCalculatorService {

    private Accountant accountant;
    private CurrencyRatingClient nbpClient;

    public ContractCalculatorService(Accountant accountant, CurrencyRatingClient nbpClient) {
        this.accountant = accountant;
        this.nbpClient = nbpClient;
    }

    public BigDecimal getCalculatedContractForCountry(String country, BigDecimal salary) {
        switch (country) {
            case "Poland": {
                accountant.setCalculatorBuilder(new PolandContractCalculatorBuilder(nbpClient));
                break;
            }
            case "Germany": {
                accountant.setCalculatorBuilder(new GermanContractCalculatorBuilder(nbpClient));
                break;
            }
            case "Great_Britain": {
                accountant.setCalculatorBuilder(new GreatBritainContractCalculatorBuilder(nbpClient));
                break;
            }
            default: {
                throw new UnsupportedCountryException("This country isn't Supported :" + country );
            }
        }
        accountant.constructContractCalculator();
        return accountant.getContractCalculator().calculateNetMonthlySalary(salary);
    }
}
