package com.pabin.kamil.zadanie_kalkulator_s

import com.pabin.kamil.zadanie_rekrutacyjne_s.IntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.client.HttpClientErrorException

class NBPClientTest extends IntegrationTest {

    @Autowired
    NBPClient nbpClient

    def "should return actual ratings for EURO"() {

        given:
        stubNBPService(200, '{"table":"C","currency":"euro","code":"EUR",' +
                '"rates":[{"no":"037/C/NBP/2018","effectiveDate":"2018-02-21","bid":4.1057,"ask":4.1887}]}',
                '/exchangerates/rates/C/eur')

        when:
        def result = nbpClient.getRatingFor("eur");

        then:
        result.currency == "euro"
        result.currencyCode == "EUR"

    }

    def "should throw 404 status code for unknown currency"() {

        given:
        stubNBPService(404,'404 NotFound',
                '/exchangerates/rates/C/randomcurrency')

        when:
        nbpClient.getRatingFor("randomcurrency")

        then:
        def e = thrown(HttpClientErrorException)
        e.statusCode == HttpStatus.NOT_FOUND
    }

}
