public class CurrentAccount extends Account {
    double overDraftLimit;
    double interestRate = 0.25; // FIXED

    CurrentAccount(int accNo, double balance, Customer owner, double overDraftLimit) {
        super(accNo, balance, owner);
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public String accountType() {
        return "current";
    }

    @Override
    double calculateInterest() {
        double balance = checkBalance();
        return (interestRate * balance) / 100;
    }

    @Override
    double getOverdraftLimit() {
        return overDraftLimit;
    }
}
