package com.pabin.kamil.zadanie_kalkulator_s;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractCalculatorEndpoint {

    @GetMapping("/{country}")
    double getCalculatedContract(@PathVariable("country") String country) {
        return 0.0;
    }

}
