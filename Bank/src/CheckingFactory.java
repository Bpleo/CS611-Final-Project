public class CheckingFactory implements AccountFactoryInterface {


    private Customer customerID;
    private CurrencyType currencyType;

    public CheckingFactory (Customer customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new CheckingAccount(0, customerID);
    }
}