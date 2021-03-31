package com.github.badpop.jcoinbase;

import com.github.badpop.jcoinbase.client.JCoinbaseClientFactory;
import com.github.badpop.jcoinbase.model.data.Currency;
import com.github.badpop.jcoinbase.model.request.UpdateCurrentUserRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Disabled("For development purpose only")
@DisplayName("Test class for development purpose only")
class DevelopmentTest {

  @Test
  void test() {

    val client =
        JCoinbaseClientFactory.build(
            "B4FyyXIxMbtAlAfe", "34ltm3h8KBzFC66YqWXhYfp4RVM80loQ", "", 3, false);

    val callResult = client.data().getCurrencies();

    val toto = callResult.map(currencies -> currencies.map(Currency::getId));

    log.info("Data : {}", toto);
    assertThat(toto).isNotNull();
  }
}