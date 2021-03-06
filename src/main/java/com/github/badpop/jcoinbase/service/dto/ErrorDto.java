package com.github.badpop.jcoinbase.service.dto;

import com.github.badpop.jcoinbase.model.CoinbaseError;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorDto {
  private final String id;
  private final String message;
  private final String url;

  public CoinbaseError toCoinbaseError() {
    return CoinbaseError.builder().code(id).message(message).url(url).build();
  }
}
