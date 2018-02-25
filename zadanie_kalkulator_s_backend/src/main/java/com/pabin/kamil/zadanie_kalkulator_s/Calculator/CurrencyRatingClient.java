package com.pabin.kamil.zadanie_kalkulator_s.Calculator;

import org.springframework.stereotype.Service;

public interface CurrencyRatingClient {

    CurrencyRating getRatingFor(String currencyCode);
}
