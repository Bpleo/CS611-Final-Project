import java.time.LocalDate;

public class LoanAccount extends Account{
    private double loanAmount;
    private CurrencyType loanType;
    private double loanInterest;
    private LocalDate loanDate;
    private LocalDate paidDate;

    public LoanAccount(int accountId, int customerId) {
        super(AccountType.LOAN, accountId, customerId);
    }
    //Must call when create a loan account
    public void requestLoan(double loanAmount, CurrencyType loanType, double loanInterest, long loanPeriod, LocalDate loanDate){
        this.loanAmount = loanAmount;
        this.loanType = loanType;
        this.loanInterest = loanInterest;
        this.loanDate = loanDate;
        this.paidDate = loanDate.plusDays(loanPeriod);
    }

    @Override // cannot withdraw from a loan
    public boolean withdraw(CurrencyType currency, double amount) {
        return false;
    }

    // if the loan is due after a month, then it will increase by interest rate
    public void increaseLoan(LocalDate date){
        if (date.equals(paidDate.plusMonths(1))) {
            loanAmount += loanAmount * loanInterest;
            paidDate = paidDate.plusMonths(1);
        }
    }

    @Override
    public void deposit(CurrencyType currency, double amount) {
        if (currency != loanType){
            double actualAmount = Exchange.exchangeCurrency(currency,loanType,amount);
            loanAmount -= actualAmount;
        }else{
            loanAmount -= amount;
        }

    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public CurrencyType getLoanType() {
        return loanType;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }
}
