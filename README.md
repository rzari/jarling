# Jarling
*Jarling* is a Java library that provides simple access to the Starling Bank API.  It aims to have minimal dependencies, currently only gson for json processing and is compatible with Java 1.8+.

## Getting Started

### Prerequisites
* Java 1.8 or greater
* [Gson](https://github.com/google/gson)

## Download
Jarling 0.1.0 can be downloaded [here](https://oss.sonatype.org/service/local/repositories/releases/content/org/jarling/jarling/0.1.0/jarling-0.1.0.jar) or added as a dependency to Maven using the following:

```xml
<dependency>
  <groupId>org.jarling</groupId>
  <artifactId>jarling</artifactId>
  <version>0.1.0</version>
</dependency>
```

## Sample Usage
You'll first need to obtain an access token.  You can either use your own account or Starling's sandbox account.
Details of how to obtain a token can be found [here](https://developer.starlingbank.com/get-started).

### Initialise Client
```java
StarlingBank starling = new Starling(StarlingBankEnvironment.PRODUCTION, "<my_personal_access_token>");
```

### Fetch your account details
```java
Account account = starling.getAccount();
System.out.println(account.getName() + "'s sort code is " + account.getSortCode() + " and your account number is " + account.getNumber());
```

### Check your account balance
```java
AccountBalance accountBalance = starling.getAccountBalance();
System.out.println("Your balance is " + accountBalance.getAmount() + " " + accountBalance.getCurrency());

```

### Return Last 100 Transactions
```java
Transaction aTransaction = starling.listTransactions.get(0);
System.out.println("You spent " + aTransaction.getAmount() + " at " + aTransaction.getNarrative()); 
```


## Built With
* [Gson](https://github.com/google/gson)


## License
This project is licensed under the MIT License - see the [LICENSE]() file for details
