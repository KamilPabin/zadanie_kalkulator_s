package com.pabin.kamil.zadanie_kalkulator_s.Calculator;


import com.pabin.kamil.zadanie_kalkulator_s.ContractCalculatorService;
import com.pabin.kamil.zadanie_kalkulator_s.Exceptions.UnsupportedCountryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
public class ContractCalculatorEndpoint {

    private ContractCalculatorService contractCalculatorService;

    public ContractCalculatorEndpoint(ContractCalculatorService contractCalculatorService) {
        this.contractCalculatorService = contractCalculatorService;
    }

    @GetMapping("/CalculateContract")
    BigDecimal getCalculatedContract(@RequestParam(value = "country") String country,
                                     @RequestParam(value = "salary") BigDecimal salary) {
        return contractCalculatorService.getCalculatedContractForCountry(country,salary);
    }

    @ExceptionHandler(UnsupportedCountryException.class)
    ResponseEntity<String> handleException(UnsupportedCountryException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
