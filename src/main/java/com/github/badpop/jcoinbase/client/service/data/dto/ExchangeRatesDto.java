package com.github.badpop.jcoinbase.client.service.data.dto;

import com.github.badpop.jcoinbase.model.data.ExchangeRates;
import io.vavr.collection.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ExchangeRatesDto {

  private final String currency;
  private final Map<String, BigDecimal> rates;

  public ExchangeRates toExchangeRates() {
    return ExchangeRates.builder().currency(currency).rates(rates).build();
  }
}
