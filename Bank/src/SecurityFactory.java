public class SecurityFactory implements AccountFactoryInterface {
    private int customerID;
    private CurrencyType currencyType;

    public SecurityFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new SecurityAccount(0, customerID);
    }
}
