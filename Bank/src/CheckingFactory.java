public class CheckingFactory implements AccountFactoryInterface {


    private int customerID;
    private CurrencyType currencyType;
    private static int accountNumber = 0;
    private int accountHolderId;

    public CheckingFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
        accountNumber++;
        this.accountHolderId = accountNumber;
    }

    @Override
    public Account createAccount () {

        return new CheckingAccount(accountHolderId, customerID);
    }
}