package com.github.badpop.jcoinbase.service.data.dto;

import com.github.badpop.jcoinbase.model.data.Currency;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyDtoTest {

  @Test
  void should_return_Currency() {
    val id = "BTC";
    val name = "Bitcoin";
    val minSize = BigDecimal.valueOf(0.01);
    val dto = CurrencyDto.builder().id(id).name(name).minSize(minSize).build();

    val actual = dto.toCurrency();

    assertThat(actual).isEqualTo(Currency.builder().id(id).name(name).minSize(minSize).build());
  }
}
