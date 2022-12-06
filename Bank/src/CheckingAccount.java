import java.util.Currency;
import java.util.HashMap;

public class CheckingAccount extends Account{
    private HashMap<Currency, Double> deposit;
    public CheckingAccount(AccountType type, double balance, int accountHolderId, int accountId, Customer customerId) {
        super(AccountType.CHECKING, balance, accountHolderId, accountId, customerId);
        deposit = new HashMap<>();
    }

    public double getDeposit(Currency currency){
        return deposit.get(currency);
    }

    public void addCurrency(Currency currency, double amount){
        if (deposit.containsKey(currency))
            deposit.put(currency,deposit.get(currency)+amount);
        else
            deposit.put(currency,amount);
    }

    //if returns -1, then it means withdraw doesn't succeed
    public double fastWithDraw(Currency currency, double amount){
        if (deposit.containsKey(currency))
            if (deposit.get(currency) < amount)
                return -1;
            else {
                deposit.put(currency,deposit.get(currency)-amount);
                return amount;
            }
        else
            return -1;
    }
}
