public class SecurityFactory implements AccountFactoryInterface {
    private Customer customerID;
    private CurrencyType currencyType;

    public SecurityFactory (Customer customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new SecurityAccount(0, customerID);
    }
}
