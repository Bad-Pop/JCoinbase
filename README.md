# JCoinbase ![Made with love](https://img.shields.io/badge/Made%20with-%3C3-red)

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/Bad-Pop/JCoinbase/JCoinbase%20CI?style=plastic)
![Sonar Coverage](https://img.shields.io/sonar/coverage/JCoinbase?server=https%3A%2F%2Fsonarcloud.io)
![Sonar Tech Debt](https://img.shields.io/sonar/tech_debt/JCoinbase?server=https%3A%2F%2Fsonarcloud.io)
![Sonar Tests](https://img.shields.io/sonar/tests/JCoinbase?compact_message&failed_label=failed&passed_label=passed&server=https%3A%2F%2Fsonarcloud.io&skipped_label=skipped)
![Sonar Quality Gate](https://img.shields.io/sonar/quality_gate/JCoinbase?server=https%3A%2F%2Fsonarcloud.Io)
![Sonar Violations (long format)](https://img.shields.io/sonar/violations/JCoinbase?format=long&server=https%3A%2F%2Fsonarcloud.io)
![GitHub last commit](https://img.shields.io/github/last-commit/Bad-Pop/JCoinbase)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/Bad-Pop/JCoinbase?color=green)
![GitHub repo size](https://img.shields.io/github/repo-size/Bad-Pop/JCoinbase)
![GitHub](https://img.shields.io/github/license/Bad-Pop/JCoinbase)
![GitHub contributors](https://img.shields.io/github/contributors/Bad-Pop/JCoinbase)
___

**This project is still under development**

JCoinbase is an open source client for the Coinbase exchange platform API. It's written in Java 15, but a Java 8 version is being considered. It allows you to make queries to the Coinbase API in a quick and easy way.

## Getting started

To make requests to Coinbase API using JCoinbase, simply instantiate a new `JcoinbaseClient` via the `JCoinbaseClientFactory`

```java  
JCoinbaseClient client = JCoinbaseClientFactory.build(yourApiKey, yourSecret, desiredTimoutInSecond, followRedirects);  
```

- Api key : Your api key generated by Coinbase in your profile settings.
- Secret : Your secret generated by Coinbase in your profile settings.
- desiredTimeoutInSeconds : A long value that defines the timeout in seconds for http requests. Recommended value is 3.
- followRedirect : A boolean defining if the `JCoinbaseClient` should follow http redirects. In common cases you should  set it to false.

_Notice that, if you pass `null` for the api key and the secret, you won't be able to access non-public Coinbase's data :  user, account, addresses, transactions, buy, sell, deposit, withdrawals and payment methods._

Then, you can simply call Coinbase resources like that :

```java
ExchangeRates exchangeRates = client.data().getExchangeRates("BTC");  
```  

Please note that, by default, returned values use Vavr data types for objects like `Collections` or `Option`.  
So if you don't want to use Vavr, you can always get java objects via the api.

For example :

```java
ExchangeRates exchangeRates = client.data().getExchangeRates("BTC");

io.vavr.collection.Map<String, BigDecimal> vavrRates = exchangeRates.getRates();
java.util.Map<String, BigDecimal> javaRates = exchangeRates.getRatesAsJavaMap();
```  

For further information on Vavr, please take a look at : [https://www.vavr.io/](https://www.vavr.io/)

## Available features

- Access Coinbase public data


## In development features

- Access Users resources


## Next features

- Account
- Addresses
- Transactions
- Buy / Sell
- Deposit
- Withdrawal
- Payment methods


## Build this project locally
If you don't have maven installed, you can use the maven wrapper presents inside the project :
```shell
./mvnw clean install
```
If you are on windows you can use the `mvnw.cmd` which also wrap maven on windows.
Else, if you have Maven installed you can run :
```shell
mvn clean install
```

## Usefull links

**SonarQube** : [https://sonarcloud.io/dashboard?id=JCoinbase](https://sonarcloud.io/dashboard?id=JCoinbase)

**Vavr <3** : [https://www.vavr.io/](https://www.vavr.io/)
