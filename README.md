# Simple Banking System

A command-line based banking management system built with Java. This application simulates basic banking operations and demonstrates core object-oriented programming principles.

## Features

* **Customer Management**: Add new customers and view the list of all existing customers.
* **Two Tiers of Customers**:
    * **Regular Customer**: Standard access and loan functionalities.
    * **VIP Customer**: Enhanced privileges, including higher loan amounts and a greater number of permissible loans.
* **Dual Account Types**:
    * **Savings Account**: With a fixed interest rate and an overdraft limit.
    * **Current Account**: Tailored for frequent transactions with its own interest rate and overdraft facility.
* **Account Operations**:
    * Check account balance.
    * Deposit and withdraw funds.
    * View past transactions.
    * Calculate potential interest.
* **Loan System**:
    * Apply for new loans with different conditions for Regular and VIP customers.
    * View all sanctioned loans.
* **Bank-wide Overview**:
    * Display a list of all accounts in the bank.
    * Show all loans disbursed by the bank.
    * Calculate and display the total funds held by the bank.

## How To Run

1.  **Compile the code**:
    ```bash
    javac *.java
    ```
2.  **Run the application**:
    ```bash
    java Main
    ```
3.  Follow the on-screen instructions to navigate through the various menus and perform banking operations.

## Class Structure

* `Main`: The main class that drives the application and handles user interaction.
* `Bank`: Represents the bank and manages the list of customers.
* `Customer`: An abstract class for customer details and actions.
    * `VIPCustomer`: A subclass for VIP customers with special privileges.
    * `RegularCustomer`: A subclass for regular customers.
* `Account`: An abstract class defining the basic structure of a bank account.
    * `SavingsAccount`: A subclass for savings accounts.
    * `CurrentAccount`: A subclass for current accounts.
* `Loan`: Represents a loan with its amount and interest rate.
* `Transaction`: Records the details of each transaction.

---