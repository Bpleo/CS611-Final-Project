import java.util.Currency;
import java.util.HashMap;

public class CheckingAccount extends Account{
    private HashMap<CurrencyType, Double> deposit;
    public CheckingAccount(int accountHolderId, Customer customerId) {
        super(AccountType.CHECKING, accountHolderId,  customerId);
        deposit = new HashMap<>();
    }

    @Override
    public void deposit(CurrencyType currency, double amount) {
        if (deposit.containsKey(currency))
            deposit.put(currency,deposit.get(currency)+amount);
        else
            deposit.put(currency,amount);
    }

    @Override
    public boolean withdraw(CurrencyType currency, double amount) {
        if (deposit.containsKey(currency))
            if (deposit.get(currency) < amount)
                return false;
            else {
                deposit.put(currency,deposit.get(currency)-amount);
                return true;
            }
        else
            return false;
    }

    public double getDeposit(Currency currency){
        return deposit.get(currency);
    }

}
