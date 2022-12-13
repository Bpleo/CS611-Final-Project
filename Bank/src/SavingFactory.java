public class SavingFactory implements AccountFactoryInterface {
    private int customerID;
    private CurrencyType currencyType;

    private static int accountNumber = 0;
    private int accountHolderId;


    public SavingFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
        accountNumber++;
        this.accountHolderId = accountNumber;
    }

    @Override
    public Account createAccount () {

        return new SavingAccount(accountHolderId, customerID);
    }
}
