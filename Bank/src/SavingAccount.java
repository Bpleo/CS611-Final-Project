import java.util.Currency;
import java.util.Date;
import java.util.HashMap;

public class SavingAccount extends Account{
    private double loanAmount;
    private double interestSaving;
    //deposit length
    //deposit date
    private double interestLoan;
    private HashMap<Currency, Double> deposit;
    public SavingAccount(AccountType type, double balance, int accountHolderId, Customer customerId) {
        super(AccountType.SAVING, balance, accountHolderId, customerId);
        setInterestLoan(0);
        setInterestSaving(0);
        setLoanAmount(0);
        deposit = new HashMap<>();
    }

    //sends in the date of the withdrawal to see if the customer can make the transaction.
    public boolean withdraw(Date date, Currency currency, double amount) {
        return false;
    }

    @Override
    public boolean withdraw(Currency currency, double amount) {
        return false;
    }

    @Override
    public void deposit(Currency currency, double amount) {
        if (deposit.containsKey(currency))
            deposit.put(currency,deposit.get(currency)+amount);
        else
            deposit.put(currency,amount);
    }

    public double getDeposit(Currency currency){
        return deposit.get(currency);
    }


    public double getInterestLoan() {
        return interestLoan;
    }

    public void setInterestLoan(double interestLoan) {
        this.interestLoan = interestLoan;
    }

    public double getInterestSaving() {
        return interestSaving;
    }

    public void setInterestSaving(double interestSaving) {
        this.interestSaving = interestSaving;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    //todo
    public boolean checkLoanEligibility(){
        return false;
    }

    //todo
    public double requestLoan(double amount){
        return 0;
    }

    //todo
    public boolean checkStockEligibility(){
        return false;
    }

    public void transferAmount(int accountId, double amount){

    }
}
