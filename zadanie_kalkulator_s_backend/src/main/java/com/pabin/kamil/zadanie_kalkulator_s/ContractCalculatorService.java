package com.pabin.kamil.zadanie_kalkulator_s;

import com.pabin.kamil.zadanie_kalkulator_s.Calculator.Accountant;
import com.pabin.kamil.zadanie_kalkulator_s.Calculator.GermanContractCalculatorBuilder;
import com.pabin.kamil.zadanie_kalkulator_s.Calculator.PolandContractCalculatorBuilder;
import com.pabin.kamil.zadanie_kalkulator_s.Exceptions.UnsupportedCountryException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ContractCalculatorService {

    private Accountant accountant;

    public ContractCalculatorService(Accountant accountant) {
        this.accountant = accountant;
    }

    public BigDecimal getCalculatedContractForCountry(String country,BigDecimal salary) {
        switch (country) {
            case "Poland": {
                accountant.setCalculatorBuilder(new PolandContractCalculatorBuilder());
                break;
            }
            case "Germany": {
                accountant.setCalculatorBuilder(new GermanContractCalculatorBuilder());
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
