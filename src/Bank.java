import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final String bankName;
    private final List<Customer> customerList;

    Bank(String name) {
        bankName = name;
        customerList = new ArrayList<>();
    }

    // TO ADD CUSTOMER IN THE BANK
    public void addCustomer(String customerType, String name) {
        Customer c;
        if (customerType.equals("vip")) {
            c = new VIPCustomer(name);
        } else {
            c = new RegularCustomer(name);
        }
        customerList.add(c);
        System.out.println("\nCustomer added successfully!!");
    }

    // TO VERIFY IS CUSTOMER EXISTED OR NOT
    Customer verifyCustomer(int id) {
        if (id <= customerList.size())
            return customerList.get(id - 1);
        else
            return null;
    }

    // -------- REQUIRED GETTER AND SETTER --------

    // GET BANK NAME
    String getBankName() {
        return bankName;
    }

    // GET LIST OF CURRENT CUSTOMERS IN THE BANK
    List<Customer> getCustomerList() {
        return customerList;
    }
}
