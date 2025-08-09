public class Loan {
    private final double loanAmount;
    private final double interestRate;
    Customer owner;

    Loan(double loanAmount, double interestRate, Customer owner) {
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.owner = owner;
    }

    // ---------- REQUIRED GETTER AND SETTER --------

    // GET LOAN AMOUNT SANCTIONED
    public double getLoanAmount() {
        return loanAmount;
    }

    // GET THE INTEREST RATE ON THE LOAN
    public double getInterestRate() {
        return interestRate;
    }
}
