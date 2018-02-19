package com.pabin.kamil.zadanie_kalkulator_s;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class NBPClientImpl implements NBPClient {

    private RestTemplate nbpRestTemplate;
    private String url;

    public NBPClientImpl(RestTemplate nbpRestTemplate,
                         @Value("${NBPClient.url}") String url) {
        this.nbpRestTemplate = nbpRestTemplate;
        this.url = url;
    }

    @Override
    public CurrencyRating getRatingFor(String currencyCode) {
        ResponseEntity<CurrencyRating> responseEntity = nbpRestTemplate.getForEntity(url +
                        "exchangerates/rates/C/" + currencyCode,
                CurrencyRating.class);
        return responseEntity.getBody();
    }
}
