public class SecurityFactory implements AccountFactoryInterface {
    private int customerID;
    private CurrencyType currencyType;
    private int accountHolderId;
    private static int accountNumber = 0;


    public SecurityFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
        accountNumber++;
        this.accountHolderId = accountNumber;
    }

    @Override
    public Account createAccount () {

        return new SecurityAccount(accountHolderId, customerID);
    }
}
