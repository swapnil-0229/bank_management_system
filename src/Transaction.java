class Transaction {
    private final String amount;
    private final String type;
    private final String currentBalance;

    Transaction(String amount, String type, String currentBalance) {
        this.amount = amount;
        this.type = type;
        this.currentBalance = currentBalance;
    }

    // --------- REQUIRED GETTER AND SETTER ---------

    // GET TRANSACTION AMOUNT
    String getAmount() {
        return amount;
    }

    // GET TYPE OF TRANSACTION
    String getType() {
        return type;
    }

    // GET THE CURRENT BALANCE OF THE ACCOUNT AT THE TIME OF THE TRANSACTION
    String getCurrentBalance() {
        return currentBalance;
    }
}
