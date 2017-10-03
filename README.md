# Jarling
*Jarling* is a Java library that provides simple access to the Starling Bank API.  It aims to have minimal dependencies, currently only gson for json processing and is compatible with Java 1.8+.

## Getting Started

### Prerequisites

* Java 1.8 or greater
* [Gson](https://github.com/google/gson)

## Sample Usage

You'll first need to obtain an access token.  You can either use your own account or Starling's sandbox account.
Details of how to obtain a token can be found [here](https://developer.starlingbank.com/get-started).

### Initialise Client

```
StarlingBank starling = new StarlingBank(StarlingBankEnvironment.PRODUCTION, "<my_personal_access_token>");
```

### Fetch your account details
```
Account account = starling.getAccount();
System.out.println(account.getName() + "'s sort code is " + account.getSortCode() + " and your account number is " + account.getNumber());
```

### Check your account balance
```
AccountBalance accountBalance = starling.getAccountBalance();
System.out.println("Your balance is " + accountBalance.getAmount() + " " + accountBalance.getCurrency());

```

### Return Last 100 Transactions
```
Transaction aTransaction = starling.listTransactions.get(0);
System.out.println("You spent " + aTransaction.getAmount() + " at " + aTransaction.getNarrative()); 
```


## Built With
* [Gson](https://github.com/google/gson)


## License
This project is licensed under the MIT License - see the [LICENSE]() file for details
