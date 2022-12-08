import java.util.Currency;

public abstract class Account {

    private AccountType type;
    private double balance;
    private int accountId;
    private Customer customerId;

    public Account(AccountType type, double balance, int accountId, Customer customerId){
        this.type = type;
        this.balance = balance;
        this.accountId = accountId;
        this.customerId = customerId;
    }

    public abstract boolean withdraw(Currency currency, double amount);
    public abstract void deposit(Currency currency, double amount);

    public AccountType getType() {
        return type;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }
}
