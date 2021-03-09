# JCoinbase ![Made with love](https://img.shields.io/badge/Made%20with-%3C3-red)

![GitHub Workflow Status](https://img.shields.io/github/workflow/status/Bad-Pop/JCoinbase/JCoinbase%20CI?style=plastic)
![Sonar Coverage](https://img.shields.io/sonar/coverage/JCoinbase?server=https%3A%2F%2Fsonarcloud.io)
![Sonar Tech Debt](https://img.shields.io/sonar/tech_debt/JCoinbase?server=https%3A%2F%2Fsonarcloud.io)
![Sonar Tests](https://img.shields.io/sonar/tests/JCoinbase?compact_message&failed_label=failed&passed_label=passed&server=https%3A%2F%2Fsonarcloud.io&skipped_label=skipped)
![Sonar Quality Gate](https://img.shields.io/sonar/quality_gate/JCoinbase?server=https%3A%2F%2Fsonarcloud.Io)
![GitHub last commit](https://img.shields.io/github/last-commit/Bad-Pop/JCoinbase)
![GitHub](https://img.shields.io/github/license/Bad-Pop/JCoinbase)
![GitHub contributors](https://img.shields.io/github/contributors/Bad-Pop/JCoinbase)
___

**This project is still under development**

JCoinbase is an open source client for the Coinbase exchange platform API. It's written in Java 15, but a Java 8 version is being considered. It allows you to make queries to the Coinbase API in a quick and easy way.


## Available features

- Access Coinbase public data
  - Time
  - Currencies
  - Exchange rates
  - Buy prices
  - Sell prices
  - Spot prices
- Access current user data


## Getting started

To make requests to Coinbase API using JCoinbase, simply instantiate a new `JcoinbaseClient` via the `JCoinbaseClientFactory`

```java  
JCoinbaseClient client = JCoinbaseClientFactory.build(yourApiKey, yourSecret, desiredTimoutInSecond, threadSafeSingleton);  
```

- Api key : Your api key generated by Coinbase in your profile settings.
- Secret : Your secret generated by Coinbase in your profile settings.
- desiredTimeoutInSeconds : A long value that defines the timeout in seconds for http requests. Recommended value is 3.
- threadSafeSingleton : A boolean defining if the `JCoinbaseClient` should be build as a thread safe singleton.

_Notice that, if you pass `null` for the api key and the secret, you won't be able to access non-public Coinbase's data :  user, account, addresses, transactions, buy, sell, deposit, withdrawals and payment methods._

Then, you can simply call Coinbase resources like that :

```java
CallResult<Seq<CoinbaseError>, User> currentUser = client.user().getCurrentUser();  
```

CallResult represents a value of two possible types, a Failure or a Success.
In this example, if this is a failure, `client.user().getCurrentUser()` will return a `CallResult.Failure`,
otherwise it will return a `CallResult.Success`. CallResult, is simplified version of vavr's `Either` and provide you a powerful API based on lambdas.
Thus, you are not dependent on vavr if you do not wish to use it.

Please note that, by default, returned values use Vavr data types for objects like `Collections` or `Option`.  
So if you don't want to use Vavr, you can always get java objects via the api.

For example :

```java
CallResult<io.vavr.collection.Seq<CoinbaseError>, User> currentUser = client.user().getCurrentUser();
CallResult<java.util.List<CoinbaseError>, User> currentUser = client.user().getCurrentUserAsJava();
```  

For further information on Vavr, please take a look at : [https://www.vavr.io/](https://www.vavr.io/)


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


## Build project locally
If you don't have maven installed, you can use the maven wrapper presents inside the project :
```shell
./mvnw clean install
```
If you are on windows you can use the `mvnw.cmd` which also wrap maven on windows.
Else, if you have Maven installed you can run :
```shell
mvn clean install
```
