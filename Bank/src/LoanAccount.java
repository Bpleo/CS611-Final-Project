import java.util.*;

public class LoanAccount extends Account{
    private double loanAmount;
    private double loanInterest;
    private double loanPeriod;
    private Date loanDate;

    public LoanAccount(int accountId, Customer customerId) {
        super(AccountType.LOAN, accountId, customerId);
    }

    @Override
    public boolean withdraw(CurrencyType currency, double amount) {
        return false;
    }

    @Override
    public void deposit(CurrencyType currency, double amount) {

    }

    //todo
    public boolean checkLoanEligibility(){
        return false;
    }

    //todo
    public double requestLoan(double amount){
        return 0;
    }

}
