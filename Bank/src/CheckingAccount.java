import java.util.Currency;
import java.util.HashMap;

public class CheckingAccount extends Account{
    private HashMap<Currency, Double> deposit;
    public CheckingAccount(AccountType type, double balance, int accountHolderId, int accountId, Customer customerId) {
        super(AccountType.CHECKING, balance, accountHolderId, accountId, customerId);
        deposit = new HashMap<>();
    }

    @Override
    public void deposit(Currency currency, double amount) {
        if (deposit.containsKey(currency))
            deposit.put(currency,deposit.get(currency)+amount);
        else
            deposit.put(currency,amount);
    }

    @Override
    public boolean withdraw(Currency currency, double amount) {
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
