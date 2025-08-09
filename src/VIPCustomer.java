import java.util.ArrayList;
import java.util.List;

public class VIPCustomer extends Customer {
    private final List<Loan> loanList;

    VIPCustomer(String name) {
        super(name);
        loanList = new ArrayList<>();
    }

    @Override
    public String getCustomerType() {
        return "vip";
    }

    @Override
    public void applyForLoan(int loanAmount) {
        if (loanAmount > 5000000 || loanAmount < 100000) {
            System.out.println("The loan limit for VIP Customer is between Rs.1,00,000 and Rs.50,00,000.");
            return;
        } else if (loanList.size() >= 6) {
            System.out.println("VIP Customer can apply only for max. 6 loans.");
            return;
        } else {
            Loan l = new Loan(loanAmount, 7.5, this);
            loanList.add(l);
        }
        System.out.println("Loan SANCTIONED successfully!!!");
    }

    @Override
    public List<Loan> getLoanList() {
        return loanList;
    }
}
