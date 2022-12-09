import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class SavingAccount extends Account{
    private HashMap<CurrencyType,  SavingDeposit> balance;// see if there is a way to make sure each type of currency have its own withdrawal date
    //when created, must deposit something in it.
    private boolean stockEligibility = false;
    private double interestSaving;

    public SavingAccount(int accountHolderId, Customer customerId, double interestSaving, CurrencyType currency, double amount) {
        super(AccountType.SAVING, accountHolderId, customerId);
        balance = new HashMap<>();
        deposit(currency, amount);
        this.interestSaving = interestSaving;
    }

    public double getInterestSaving() {
        return interestSaving;
    }

    public void setInterestSaving(double interestSaving) {
        this.interestSaving = interestSaving;
    }

    @Override
    public boolean withdraw(CurrencyType currency, double amount) {
        return withdraw(LocalDate.now(),currency,amount);
    }

    @Override
    public void deposit(CurrencyType currency, double amount) {
        if (balance.containsKey(currency))
            balance.get(currency).setAmount(balance.get(currency).getAmount() + amount);
        else{
            SavingDeposit tempS = new SavingDeposit(LocalDate.now(), amount);
            balance.put(currency,tempS);
        }
        if (Exchange.exchangeCurrency(currency,CurrencyType.USD,balance.get(currency).getAmount()) >= 5000)
            stockEligibility = true;
    }

    //sends in the date of the withdrawal to see if the customer can make the transaction.
    public boolean withdraw(LocalDate date, CurrencyType currency, double amount) {
        if (!balance.containsKey(currency))
            return false;
        else
            if (balance.get(currency).getAmount() < amount)
                return false;
            else {
                double tempD = balance.get(currency).getAmount();
                balance.get(currency).setWithdrawTimes(balance.get(currency).getWithdrawTimes()-1);
                balance.get(currency).setAmount(tempD - amount);
                return true;
            }
    }

    public void interestIncrease(LocalDate date){
        for(CurrencyType i : balance.keySet()){
            SavingDeposit temp = balance.get(i);
            if (temp.getDepositDate().plusMonths(1).equals(date))
                temp.setAmount(temp.getAmount() + temp.getAmount() * interestSaving);
                temp.setDepositDate(temp.getDepositDate().plusMonths(1));
        }
    }

    public double getBalance(CurrencyType currency){
        return balance.get(currency).getAmount();
    }

    //todo
    public boolean checkSecurityTransferEligibility(CurrencyType currency){
        return stockEligibility;
    }

}
