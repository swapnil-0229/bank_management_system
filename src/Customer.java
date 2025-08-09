
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    private final String customerName;
    Account saving;
    Account current;

    Customer(String name) {
        customerName = name;
    }

    // ALL ABSTRACT METHODS
    abstract String getCustomerType();

    abstract void applyForLoan(int loanAmount);

    abstract List<Loan> getLoanList();

    // GET ACCOUNT DETAILS
    public Account getAccountDetails(String accountType) {
        if (accountType.equals("saving"))
            return saving;
        else
            return current;
    }

    // CREATE A NEW SAVING ACCOUNT IF NOT EXISTED BEFORE
    public void createSavingAccount() {
        if (saving != null) {
            System.out.println("SAVING account exist already...");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Acc No - ");
        int accNo = sc.nextInt();
        System.out.print("Enter Starting balance - ");
        int balance = sc.nextInt();
        saving = new SavingsAccount(accNo, balance, this);
        System.out.println("SAVINGS account created successfully...");
    }

    // CREATE A NEW CURRENT ACCOUNT IF NOT EXISTED BEFORE
    public void createCurrentAccount() {
        if (current != null) {
            System.out.println("CURRENT account exist already...");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Acc No - ");
        int accNo = sc.nextInt();
        System.out.print("Enter Starting balance - ");
        int balance = sc.nextInt();
        System.out.print("Enter Overdraft limit - ");
        double overdraftLimit = sc.nextDouble();
        current = new CurrentAccount(accNo, balance, this, overdraftLimit);
        System.out.println("CURRENT account created successfully...");
    }

    // ----------- REQUIRED GETTER AND SETTER ------------

    // GET CUSTOMER NAME
    public String showCustomerName() {
        return customerName;
    }
}
