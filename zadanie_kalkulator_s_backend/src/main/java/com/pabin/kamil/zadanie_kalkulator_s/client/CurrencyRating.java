package com.pabin.kamil.zadanie_kalkulator_s.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRating {

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("code")
    public String currencyCode;

    @JsonProperty("rates")
    public ArrayList<Rates> rates;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Rates {

        @JsonProperty("bid")
        public String buyFor;

        @JsonProperty("ask")
        public String sellFor;
    }
}
