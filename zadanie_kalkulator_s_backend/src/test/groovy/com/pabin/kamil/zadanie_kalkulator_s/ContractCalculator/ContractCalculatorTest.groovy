package com.pabin.kamil.zadanie_kalkulator_s.ContractCalculator

import com.pabin.kamil.zadanie_kalkulator_s.calculator.ContractCalculator
import spock.lang.Specification

class ContractCalculatorTest extends Specification {

    def "should calculate net monthly salary"() {

        given:
        def calc = new ContractCalculator()
        calc.setLivingCost(livingCost)
        calc.setRating(rating)
        calc.setTax(tax)

        when:
        def result = calc.calculateNetMonthlySalary(dailySalary)

        then:
        result == netMonthlySalary

        where:
        livingCost | rating | tax  | dailySalary || netMonthlySalary
        600        | 2.52   | 0.19 | 100         || 2978.64
        821        | 4.99   | 0.23 | 128         || 6723.1268
        628        | 1.59   | 0.15 | 68          || 1023.324
        1200       | 3.18   | 0.27 | 192         || 5989.5936
        923        | 5.61   | 0.3  | 165         || 9076.98
        850        | 8.12   | 0.18 | 92          || 6574.6016
    }

}
