package com.github.badpop.jcoinbase.client.dto.data;

import com.github.badpop.jcoinbase.model.Currency;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyDtoTest {

  @Test
  void should_return_Currency() {

    var dto = new CurrencyDto("BTC", "Bitcoin", BigDecimal.valueOf(0.01));
    var actual = dto.toCurrency();

    assertThat(actual)
        .isEqualTo(
            Currency.builder().id("BTC").name("Bitcoin").minSize(BigDecimal.valueOf(0.01)).build());
  }
}
