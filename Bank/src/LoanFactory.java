public class LoanFactory implements AccountFactoryInterface {

    private Customer customerID;
    private CurrencyType currencyType;

    public LoanFactory (Customer customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new LoanAccount(0, customerID);
    }
    
}
