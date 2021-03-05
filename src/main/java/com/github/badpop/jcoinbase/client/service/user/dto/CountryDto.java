package com.github.badpop.jcoinbase.client.service.user.dto;

import com.github.badpop.jcoinbase.model.user.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CountryDto {
  private final String code;
  private final String name;
  private final boolean isInEurope;

  public Country toCountry() {
    return Country.builder().code(code).name(name).inEurope(isInEurope).build();
  }
}
