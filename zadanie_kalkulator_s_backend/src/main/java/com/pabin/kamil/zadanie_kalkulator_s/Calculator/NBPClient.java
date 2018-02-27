package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NBPClient implements CurrencyRatingClient {

    private RestTemplate nbpRestTemplate;
    private String url;

    public NBPClient(RestTemplate nbpRestTemplate,
                     @Value("${NBPClient.url}") String url) {
        this.nbpRestTemplate = nbpRestTemplate;
        this.url = url;
    }

    @Override
    public CurrencyRating getRatingFor(String currencyCode) {
        ResponseEntity<CurrencyRating> responseEntity = nbpRestTemplate.getForEntity(url +
                        "/exchangerates/rates/c/" + currencyCode,
                CurrencyRating.class);
        return responseEntity.getBody();
    }
}
