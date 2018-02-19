package com.pabin.kamil.zadanie_kalkulator_s;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRating {

    @JsonProperty("currency")
    String currency;

    @JsonProperty("code")
    String currencyCode;

    @JsonProperty("rates")
    ArrayList<Rates> rates;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rates {

        @JsonProperty("bid")
        double buyFor;

        @JsonProperty("ask")
        double sellFor;
    }
}
