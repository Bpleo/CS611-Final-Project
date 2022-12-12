public class SavingFactory implements AccountFactoryInterface {
    private int customerID;
    private CurrencyType currencyType;

    public SavingFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new SavingAccount(0, customerID);
    }
}
