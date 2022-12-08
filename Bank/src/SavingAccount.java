import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;

public class SavingAccount extends Account{
    private double interestSaving;
    private LocalDate depositDate;
    private LocalDate withdrawDate;
    private HashMap<CurrencyType, Double> balance;
    //when created, must deposit something in it.
    public SavingAccount(int accountHolderId, Customer customerId, int depositPeriod, LocalDate depositDate, double interestSaving) {
        super(AccountType.SAVING, accountHolderId, customerId);
        setInterestSaving(interestSaving);
        balance = new HashMap<>();
        this.depositDate = depositDate;
        withdrawDate = depositDate.plusDays(depositPeriod);
    }

    //sends in the date of the withdrawal to see if the customer can make the transaction.
    public boolean withdraw(LocalDate date, CurrencyType currency, double amount) {
        if (date.compareTo(withdrawDate) < 0)
            return false;
        else
            return withdraw(currency, amount);
    }

    @Override
    public boolean withdraw(CurrencyType currency, double amount) {
        if (balance.containsKey(currency))
            if (balance.get(currency) < amount)
                return false;
            else {
                balance.put(currency,balance.get(currency)-amount);
                return true;
            }
        else
            return false;
    }

    @Override
    public void deposit(CurrencyType currency, double amount) {
        if (balance.containsKey(currency))
            balance.put(currency,balance.get(currency)+amount);
        else
            balance.put(currency,amount);
    }

    public double getBalance(CurrencyType currency){
        return balance.get(currency);
    }

    public double getInterestSaving() {
        return interestSaving;
    }

    public void setInterestSaving(double interestSaving) {
        this.interestSaving = interestSaving;
    }

    public LocalDate getDepositDate() {
        return depositDate;
    }

    public LocalDate getWithdrawDate() {
        return withdrawDate;
    }

    //todo
    public boolean checkStockEligibility(){
        return false;
    }


}
