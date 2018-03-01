package com.pabin.kamil.zadanie_kalkulator_s

import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpClientErrorException

class ContractCalculatorEndpointIntegrationTest extends IntegrationTest {

    def "Should return calculated net salary for Poland"() {

        when:
        def response = restTemplate.getForEntity("http://localhost:$port/CalculateContract" +
                "?country=Poland&salary=100", BigDecimal.class)

        then:
        response.body == 582
    }

    def "Should return calculated net salary for Germany"() {

        given:
        stubNBPService(200, '{"table":"C","currency":"euro","code":"EUR",' +
                '"rates":[{"no":"037/C/NBP/2018","effectiveDate":"2018-02-21","bid":4.1057,"ask":4.1887}]}',
                '/exchangerates/rates/c/eur')

        when:
        def response = restTemplate.getForEntity("http://localhost:$port/CalculateContract" +
                "?country=Germany&salary=100", BigDecimal.class)

        then:
        response.body == 3941.472
    }

    def "should return 400 Bad Request status code"() {

        when:
        def response = restTemplate.getForEntity("http://localhost:$port/CalculateContract" +
                "?country=NotSupportedCountry&salary=100", BigDecimal.class)

        then:
        def e = thrown(HttpClientErrorException)
        e.statusCode == HttpStatus.BAD_REQUEST
    }


}
