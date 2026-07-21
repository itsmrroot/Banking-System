# 🏦 Bank Management System

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
- List all customers in a branch, optionally including their full transaction history
- Duplicate-safe: adding a branch or customer that already exists is rejected (returns `false`) instead of silently overwriting data

## Project Structure

```
src/
└── com/company/
    ├── Main.java      # Entry point
    ├── Bank.java       # Top-level bank operations
    ├── Branch.java     # Branch-level operations
    └── Customer.java   # Customer data model
```

## Requirements

- Java 11 or later (JDK)
- No external dependencies — pure Java standard library (`java.util.ArrayList`)

## Getting Started

### Run from source (no build tool)

```bash
# Compile
javac -d out $(find src -name "*.java")

# Run
java -cp out com.company.Main
```

### Example usage

```java
Bank bank = new Bank("First National");

bank.addBranch("Downtown");
bank.addCustomer("Downtown", "Alice", 1000.0);
bank.addCustomerTransaction("Downtown", "Alice", -250.0);
bank.addCustomerTransaction("Downtown", "Alice", 500.0);

bank.listCustomers("Downtown", true);
```

Sample output:

```
Customer details for branch Downtown
Customer: Alice[1]
Transactions
[1] Amount 1000.0
[2] Amount -250.0
[3] Amount 500.0
```

## Building a Runnable JAR

To distribute this as a standalone `.jar` file, add a build tool such as Maven:

```bash
mvn package
java -jar target/bank-management-1.0.jar
```

Your `pom.xml` should configure the `maven-jar-plugin` (or `maven-assembly-plugin` for a fat JAR) with a manifest entry pointing to `com.company.Main`.

## Creating a Native Installer (optional)

Once you have a runnable JAR, JDK's built-in `jpackage` tool can bundle it into a native installer with its own runtime, so end users don't need Java installed separately:

```bash
jpackage \
  --input target/ \
  --main-jar bank-management-1.0.jar \
  --main-class com.company.Main \
  --name BankManagement \
  --type exe   # or dmg / deb / rpm depending on target OS
```

## Roadmap / Known Limitations

- [ ] Use `BigDecimal` instead of `double` for monetary values to avoid floating-point rounding errors
- [ ] Add input validation (no negative initial balances, no null/empty names)
- [ ] Add `getBalance()` to `Customer` to sum transactions
- [ ] Separate display logic (`System.out.println`) from business logic in `Bank`/`Branch`
- [ ] Add unit tests (JUnit 5)
- [ ] Replace boolean return values with descriptive exceptions for clearer error handling
- [ ] Rename base package from `com.company` to something project-specific

## License

Add a license of your choice (e.g. MIT) before publishing publicly.

## Contributing

Issues and pull requests are welcome once the repository is published.
