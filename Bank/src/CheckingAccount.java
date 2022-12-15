
import java.util.LinkedHashMap;
import java.util.Optional;

public class CheckingAccount extends Account{
    private LinkedHashMap<CurrencyType, Double> deposit;
    public CheckingAccount(int accountHolderId, int customerId) {
        super(AccountType.CHECKING, accountHolderId,  customerId);
        deposit = new LinkedHashMap<>();
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
        if (currency == CurrencyType.USD){
            if (deposit.containsKey(CurrencyType.USD)){
                deposit.put(currency, deposit.get(currency) - amount);
                return true;
            } else {
                CurrencyType temp = deposit.keySet().stream().findFirst().get();
                double usdEquiAmount = Exchange.exchangeCurrency(CurrencyType.USD, temp, amount);
                return withdraw(temp, usdEquiAmount);
            }
        } else if (deposit.containsKey(currency))
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
