# 🏦 Bank Management System

[![CI](https://github.com/itsmrroot/Banking-System/actions/workflows/ci.yml/badge.svg)](https://github.com/itsmrroot/Banking-System/actions/workflows/ci.yml)

A simple, object-oriented Java console application for managing a bank's branches, customers, and transactions.

## Overview

This project models a small banking domain with a clean, layered structure:

```
Bank
 └── Branch (many)
      └── Customer (many)
           └── Transactions (list of amounts)
```

- **`Bank`** — top-level entity; manages a collection of branches.
- **`Branch`** — belongs to a bank; manages a collection of customers.
- **`Customer`** — belongs to a branch; holds a name and a list of transaction amounts.
- **`Main`** — application entry point.

## Features

- Add branches to a bank
- Add customers to a branch (with an initial transaction)
- Record additional transactions for an existing customer
- Calculate a customer's running balance
- List all customers in a branch, optionally including their full transaction history
- Duplicate-safe: adding a branch or customer that already exists is rejected instead of silently overwriting data
- Input validation: empty names and negative initial balances are rejected with a clear exception
- Monetary values use `BigDecimal`, not `double`, to avoid floating-point rounding errors

## Project Structure

```
src/
├── main/java/com/company/
│   ├── Main.java       # Entry point
│   ├── Bank.java        # Top-level bank operations
│   ├── Branch.java      # Branch-level operations
│   └── Customer.java    # Customer data model
└── test/java/com/company/
    └── CustomerTest.java
```

## Requirements

- Java 11 or later (JDK)
- Maven

## Getting Started

```bash
mvn package
java -jar target/bank-management.jar
```

`mvn package` compiles the code, runs the test suite, and produces a runnable JAR at `target/bank-management.jar`.

### Example usage

```java
Bank bank = new Bank("First National");

bank.addBranch("Downtown");
bank.addCustomer("Downtown", "Alice", new BigDecimal("1000.00"));
bank.addCustomerTransaction("Downtown", "Alice", new BigDecimal("-250.00"));
bank.addCustomerTransaction("Downtown", "Alice", new BigDecimal("500.00"));

bank.listCustomers("Downtown", true);
System.out.println("Alice's balance: " + bank.getCustomerBalance("Downtown", "Alice"));
```

Sample output:

```
Customer details for branch Downtown
Customer: Alice[1]
Transactions
[1] Amount 1000.00
[2] Amount -250.00
[3] Amount 500.00
Alice's balance: 1250.00
```

## Running Tests

```bash
mvn test
```

## Downloads

Prebuilt releases, including a macOS installer, are available on the [Releases page](https://github.com/itsmrroot/Banking-System/releases).

## Creating a Native Installer

Once you have a runnable JAR, JDK's built-in `jpackage` tool can bundle it into a native installer with its own runtime, so end users don't need Java installed separately:

```bash
jpackage \
  --input target/ \
  --main-jar bank-management.jar \
  --main-class com.company.Main \
  --name BankManagement \
  --app-version 1.0.0 \
  --type dmg   # or exe / deb / rpm depending on target OS
```

Note: this is a console application, so the installed app will open and close a terminal window quickly rather than presenting a GUI. To see its output, run the bundled binary directly, e.g. on macOS:
```bash
/Applications/BankManagement.app/Contents/MacOS/BankManagement
```

## Roadmap / Known Limitations

- [x] Use `BigDecimal` instead of `double` for monetary values
- [x] Add input validation (no negative initial balances, no null/empty names)
- [x] Add `getBalance()` to `Customer` to sum transactions
- [x] Add unit tests (JUnit 5)
- [x] Set up Maven build and CI
- [ ] Separate display logic (`System.out.println`) from business logic in `Bank`/`Branch`
- [ ] Replace boolean return values with descriptive exceptions for clearer error handling throughout (currently only `newCustomer` does this)

## Notes

The current implementation uses `System.out.println` directly inside `Bank`/`Branch`
rather than separating display from business logic, and only `newCustomer` uses
exceptions for error handling — the rest still return `boolean`. Both are reasonable
next steps if this grows further.

## License

MIT — see [LICENSE](LICENSE).

## Contributing

Issues and pull requests are welcome.
