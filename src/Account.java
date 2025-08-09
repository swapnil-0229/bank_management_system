import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

abstract class Account {
    private final int accNo;
    private double balance;
    private final Customer owner;
    private final List<Transaction> transactions;

    Account(int accNo, double balance, Customer owner) {
        this.accNo = accNo;
        this.balance = balance;
        this.owner = owner;

        transactions = new ArrayList<>();
    }

    // ALL ABSTRACT METHODS
    abstract String accountType();

    abstract double calculateInterest();

    abstract double getOverdraftLimit();

    // Deposit money to the account
    void deposit(double amount) {
        String accountType = this.accountType();
        double overdraftLimit = this.getOverdraftLimit();

        if (accountType.equals("current") && amount > overdraftLimit) {
            System.out.println("Limit for deposit in your CURRENT account is Rs." + overdraftLimit);
        } else {
            balance += amount;
            HashMap<String, String> txn = new HashMap<>();
            txn.put("amount", String.valueOf(amount));
            txn.put("balance", String.valueOf(balance));
            txn.put("type", "deposit");
            transactions.add(new Transaction(String.valueOf(amount), String.valueOf(balance), "deposit"));

            System.out.println("Transaction successfull!!!");
            System.out.println("CURRENT BALANCE - Rs." + balance);
        }
    }

    // Withdraw balance
    void withdraw(double amount) {
        String customerType = owner.getCustomerType();
        String accountType = this.accountType();
        double overdraftLimit = this.getOverdraftLimit();

        if (amount > overdraftLimit) {
            System.out.println("Limit for withdrawal from your "
                    + (accountType.equals("saving") ? "SAVINGS" : "CURRENT") + "account is Rs." + overdraftLimit);
        } else if (amount > balance) {
            System.out.println("Not enough balance...");
        } else {
            balance -= amount;
            transactions.add(new Transaction(String.valueOf(amount), String.valueOf(balance), "withdraw"));

            System.out.println("Transaction successfull!!!");
            System.out.println("CURRENT BALANCE - Rs." + balance);
        }
    }

    // ------------ REQUIRED GETTER AND SETTER --------------
    // Retrieve Account Number
    int getAccNo() {
        return accNo;
    }

    // Retrieve Owner Name
    Customer getOwner() {
        return owner;
    }

    // Retrieve Balance
    double checkBalance() {
        return this.balance;
    }

    // Get Transaction list
    List<Transaction> getTransactions() {
        return transactions;
    }
}
