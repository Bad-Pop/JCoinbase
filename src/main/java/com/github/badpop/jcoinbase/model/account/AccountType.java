package com.github.badpop.jcoinbase.model.account;

import io.vavr.collection.Seq;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

import static io.vavr.API.List;

/** Enum representing the Coinbase account type model and centralize values*/
@Getter
@AllArgsConstructor
public enum AccountType {
  WALLET("wallet"),
  FIAT("fiat"),
  VAULT("vault"),
  UNKNOWN("unknown");

  private static final Seq<AccountType> values = List(values());
  private final String type;

  public static Optional<AccountType> fromStringAsJava(final String type) {
    return fromString(type).toJavaOptional();
  }

  public static Option<AccountType> fromString(final String type) {
    return values.find(at -> at.getType().equalsIgnoreCase(type));
  }
}
