import java.util.ArrayList;
import java.util.List;

public class RegularCustomer extends Customer {
    private final List<Loan> loanList;

    RegularCustomer(String name) {
        super(name);
        loanList = new ArrayList<>();
    }

    @Override
    public String getCustomerType() {
        return "regular";
    }

    @Override
    public void applyForLoan(int loanAmount) {
        if (loanAmount > 1000000 || loanAmount < 100000) {
            System.out.println("The loan limit for REGULAR Customer is between Rs.1,00,000 and Rs.10,00,000.");
            return;
        } else if (loanList.size() >= 3) {
            System.out.println("REGULAR Customer can apply only for max. 3 loans.");
            return;
        } else {
            Loan l = new Loan(loanAmount, 12.5, this);
            loanList.add(l);
        }
        System.out.println("Loan SANCTIONED successfully!!!");
        return;
    }

    @Override
    public List<Loan> getLoanList() {
        return loanList;
    }

}
