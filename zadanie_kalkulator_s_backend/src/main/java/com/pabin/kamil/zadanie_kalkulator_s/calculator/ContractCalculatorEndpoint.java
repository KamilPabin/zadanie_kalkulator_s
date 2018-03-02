package com.pabin.kamil.zadanie_kalkulator_s.calculator;


import com.pabin.kamil.zadanie_kalkulator_s.calculator.dto.NetMonthlySalaryDto;
import com.pabin.kamil.zadanie_kalkulator_s.calculator.exceptions.UnsupportedCountryException;
import com.pabin.kamil.zadanie_kalkulator_s.client.CurrencyRating;
import com.pabin.kamil.zadanie_kalkulator_s.client.CurrencyRatingClient;
import com.pabin.kamil.zadanie_kalkulator_s.ContractCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
    ResponseEntity<NetMonthlySalaryDto> getCalculatedContract(@RequestParam(value = "country") String country,
                                                              @RequestParam(value = "salary") BigDecimal salary) {
        NetMonthlySalaryDto dto = new NetMonthlySalaryDto();
        dto.salary = contractCalculatorService.getCalculatedContractForCountry(country, salary);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/getRating")
    CurrencyRating getRating() {
        return nbpClient.getRatingFor("eur");
    }

    @ExceptionHandler(UnsupportedCountryException.class)
    ResponseEntity<String> handleException(UnsupportedCountryException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
