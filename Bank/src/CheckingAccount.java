
import java.util.HashMap;

public class CheckingAccount extends Account{
    private HashMap<CurrencyType, Double> deposit;
    public CheckingAccount(int accountHolderId, int customerId) {
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

    public double getDeposit(CurrencyType currency){
        if (deposit.containsKey(currency))
            return deposit.get(currency);
        else
            return -1;
    }

}
