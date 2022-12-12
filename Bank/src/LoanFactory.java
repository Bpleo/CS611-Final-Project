public class LoanFactory implements AccountFactoryInterface {

    private int customerID;
    private CurrencyType currencyType;

    public LoanFactory (int customerID, CurrencyType currencyType) {
        this.currencyType = currencyType;
        this.customerID = customerID;
    }

    @Override
    public Account createAccount () {

        return new LoanAccount(0, customerID);
    }
    
}
