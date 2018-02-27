package com.pabin.kamil.zadanie_kalkulator_s.Calculator;


import com.pabin.kamil.zadanie_kalkulator_s.ContractCalculatorService;
import com.pabin.kamil.zadanie_kalkulator_s.Exceptions.UnsupportedCountryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ContractCalculatorEndpoint {

    @Autowired
    ApplicationContext applicationContext;

    @GetMapping("/status/beans")
    public List<String> getBeans() {
        return Arrays.asList(applicationContext.getBeanDefinitionNames());
    }

    private ContractCalculatorService contractCalculatorService;
    private CurrencyRatingClient nbpClient;

    public ContractCalculatorEndpoint(ContractCalculatorService contractCalculatorService,
                                      CurrencyRatingClient nbpClient) {
        this.contractCalculatorService = contractCalculatorService;
        this.nbpClient = nbpClient;
    }

    @GetMapping("/CalculateContract")
    BigDecimal getCalculatedContract(@RequestParam(value = "country") String country,
                                     @RequestParam(value = "salary") BigDecimal salary) {
        return contractCalculatorService.getCalculatedContractForCountry(country, salary);
    }

    @GetMapping("/getRating")
    CurrencyRating getRating(){
        return nbpClient.getRatingFor("eur");
    }

    @ExceptionHandler(UnsupportedCountryException.class)
    ResponseEntity<String> handleException(UnsupportedCountryException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
