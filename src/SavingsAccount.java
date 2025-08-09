public class SavingsAccount extends Account {
    double interestRate = 1.25; // FIXED
    double overdraftLimit;

    SavingsAccount(int accNo, double balance, Customer owner) {
        super(accNo, balance, owner);
        if (owner.getCustomerType().equals("vip"))
            overdraftLimit = 1000000;
        else
            overdraftLimit = 30000;
    }

    @Override
    public String accountType() {
        return "saving";
    }

    @Override
    double calculateInterest() {
        double balance = checkBalance();
        return (interestRate * balance) / 100;
    }

    @Override
    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
