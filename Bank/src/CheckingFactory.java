public class CheckingFactory implements AccountFactoryInterface {


    private int customerID;
    private CurrencyType currencyType;

    public CheckingFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new CheckingAccount(0, customerID);
    }
}