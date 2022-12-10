public class SavingFactory implements AccountFactoryInterface {
    private Customer customerID;
    private CurrencyType currencyType;

    public SavingFactory (Customer customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new SavingAccount(0, customerID);
    }
}
