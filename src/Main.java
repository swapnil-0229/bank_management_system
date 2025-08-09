import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Bank b;
    static Scanner sc;

    public static void main(String[] args) {
        b = new Bank("DMI Bank");
        sc = new Scanner(System.in);
        System.out.println("Welcome to - " + b.getBankName());
        while (mainMenu()) {
        }
        System.out.println("!! THANK YOU FOR THE VISIT !!");
    }

    public static boolean mainMenu() {
        System.out.println("\nMAIN MENU -");
        System.out.println("1. Customer");
        System.out.println("2. Get all Accounts");
        System.out.println("3. Get all Loans");
        System.out.println("4. Total Money");
        System.out.println("5. Exit");
        System.out.print("\nSelect from the above options: ");

        int res = sc.nextInt();
        switch (res) {
            case 1:
                customer();
                break;
            case 2:
                getAllAccounts();
                break;
            case 3:
                getAllLoans();
                break;
            case 4:
                getTotalMoney();
                break;
            case 5:
                return false;
            default:
                System.out.println("Invalid choice !!");
                System.out.println("Try again? \n1. Yes \n2. No");
                return sc.nextInt() == 1;
        }
        return true;
    }

    public static void customer() {
        while (true) {
            System.out.println("\nCUSTOMER MENU -");
            System.out.println("1. Add New Customer");
            System.out.println("2. Check Existing Customers");
            System.out.println("3. Select a customer");
            System.out.println("4. Back to main menu");
            System.out.print("\nSelect from the above options: ");

            int res = sc.nextInt();
            switch (res) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    getListOfCustomers();
                    break;
                case 3:
                    selectCustomer();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice !!");
                    return;
            }
        }
    }

    public static void addCustomer() {
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.println("TYPE - ");
        System.out.println("1. VIP");
        System.out.println("2. Regular");
        System.out.print("Select customer type: ");

        int res = sc.nextInt();

        if (res == 1) {
            b.addCustomer("vip", name);
        } else if (res == 2) {
            b.addCustomer("regular", name);
        } else {
            System.out.println("Invalid choice !!");
        }
    }

    public static void getListOfCustomers() {
        List<Customer> customerList = b.getCustomerList();
        if (customerList.isEmpty()) {
            System.out.println("No customer found in this bank...");
            return;
        }
        System.out.println("\nLIST OF CUSTOMERS - ");
        for (int i = 0; i < customerList.size(); i++) {
            Customer c = customerList.get(i);
            System.out.println((i + 1) + ". " + c.showCustomerName() + " - "
                    + (c.getCustomerType().equals("vip") ? "VIP" : "REGULAR"));
        }
    }

    public static void selectCustomer() {
        System.out.print("Enter Customer ID - ");
        int res = sc.nextInt();

        Customer c = b.verifyCustomer(res);
        if (c == null) {
            System.out.println("Customer doesn't exist !!!\n");
            return;
        }
        System.out.println("DETAILS - ");
        System.out.println("Name: " + c.showCustomerName());
        System.out.println("Type: " + (c.getCustomerType().equals("vip") ? "VIP" : "REGULAR"));

        while (true) {
            System.out.println("\nMENU -");
            System.out.println("1. Accounts");
            System.out.println("2. Create New Account");
            System.out.println("3. Existing loans");
            System.out.println("4. Apply for a new loan");
            System.out.println("5. Back to previous menu");
            System.out.print("Select from the above options: ");

            res = sc.nextInt();

            if (res == 1) {
                System.out.println("\nTYPE -");
                System.out.println("1. Saving");
                System.out.println("2. Current");
                System.out.print("Select from the above options: ");

                int temp = sc.nextInt();
                Account acc;
                if (temp == 1)
                    account(c.getAccountDetails("saving"));
                else if (temp == 2)
                    account(c.getAccountDetails("current"));
                else
                    System.out.println("Invalid choice...");
            } else if (res == 2) {
                System.out.println("\nTYPE -");
                System.out.println("1. Saving");
                System.out.println("2. Current");
                System.out.print("Select from the above options: ");

                int temp = sc.nextInt();
                if (temp == 1)
                    c.createSavingAccount();
                else if (temp == 2)
                    c.createCurrentAccount();
                else
                    System.out.println("Invalid choice...");
            } else if (res == 3) {
                List<Loan> loanList = c.getLoanList();
                if (loanList.isEmpty()) {
                    System.out.println("No loans sanctioned by this bank...");
                } else {
                    int i = 0;
                    System.out.println("\nLIST OF LOANS - ");
                    for (Loan loan : loanList) {
                        System.out.println(++i + ". Amount - " + loan.getLoanAmount());
                        System.out.println("Interest Rate - " + loan.getInterestRate());
                    }
                }
            } else if (res == 4) {
                System.out.print("Enter Loan amount - ");
                int loanAmount = sc.nextInt();
                c.applyForLoan(loanAmount);
            } else {
                return;
            }
        }
    }

    public static void account(Account account) {
        if (account == null) {
            System.out.println("Account does not exist...");
            return;
        }
        while (true) {
            System.out.println("\nACCOUNT MENU -");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Calculate interest");
            System.out.println("5. Past transactions");
            System.out.println("6. Back to previous menu");
            System.out.print("Select from the above options: ");

            int res = sc.nextInt();
            if (res == 1) {
                System.out.println("BALANCE - Rs." + account.checkBalance());
            } else if (res == 2) {
                System.out.print("Enter withdrawal amount - Rs.");
                double amount = sc.nextDouble();
                account.withdraw(amount);
            } else if (res == 3) {
                System.out.print("Enter deposit amount - Rs.");
                double amount = sc.nextDouble();
                account.deposit(amount);
            } else if (res == 4) {
                System.out.println("Interest Amount - Rs." + account.calculateInterest());
            } else if (res == 5) {
                getAllTransactions(account.getTransactions());
            } else
                return;
        }
    }

    public static void getAllAccounts() {
        List<Account> allAccounts = new ArrayList<>();
        List<Customer> customerList = b.getCustomerList();
        for (Customer c : customerList) {
            if (c.saving != null)
                allAccounts.add(c.saving);
            if (c.current != null)
                allAccounts.add(c.current);
        }

        if (allAccounts.isEmpty()) {
            System.out.println("No accounts found in this bank...");
            return;
        }

        int i = 0;
        for (Account acc : allAccounts) {
            System.out.println();
            System.out.println(++i + ". Account Number - " + acc.getAccNo());
            System.out.println("Owner - " + acc.getOwner().showCustomerName());
            System.out.println("Type - " + (acc.accountType().equals("saving") ? "SAVING" : "CURRENT"));
            System.out.println("Balance - " + acc.checkBalance());
        }
    }

    public static void getAllLoans() {
        List<Loan> allLoans = new ArrayList<>();
        List<Customer> customerList = b.getCustomerList();
        for (Customer c : customerList) {
            allLoans.addAll(c.getLoanList());
        }

        if (allLoans.isEmpty()) {
            System.out.println("No loans sanctioned by this bank...");
            return;
        }

        int i = 0;
        System.out.println("\nLIST OF ALL LOANS - ");
        for (Loan loan : allLoans) {
            System.out.println(++i + ". Amount - " + loan.getLoanAmount());
            System.out.println("Interest Rate - " + loan.getInterestRate());
            System.out.println("By - " + loan.owner.showCustomerName());
        }
    }

    public static void getTotalMoney() {
        double totalMoney = 0.0d;
        List<Customer> customerList = b.getCustomerList();
        for (Customer c : customerList) {
            if (c.saving != null)
                totalMoney += c.saving.checkBalance();
            if (c.current != null)
                totalMoney += c.current.checkBalance();
        }
        System.out.println("Total Money in the bank - Rs." + totalMoney);
    }

    public static void getAllTransactions(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("No transactions made in this account...");
            return;
        }

        int i = 0;
        System.out.println("\nLIST OF ALL LOANS - ");
        for (Transaction txn : transactions) {
            System.out.println(++i + ". Amount - " + txn.getAmount());
            System.out.println("Balance - " + txn.getCurrentBalance());
            System.out.println("Type - " + (txn.getType().equals("withdraw") ? "WITHDRAW" : "DEPOSIT"));
        }
    }
}