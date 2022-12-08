import java.util.ArrayList;
import java.util.Currency;

public class SecurityAccount extends Account{
    private double stockBalance;
    private double profit;
    private double loss;
    private ArrayList<Stock> stockListOwned;

    public SecurityAccount(AccountType type, double balance,  int accountId, Customer customerId) {
        super(type, balance, accountId, customerId);
        setLoss(0);
        setProfit(0);
        setStockBalance(0);
    }

    @Override
    public boolean withdraw(Currency currency, double amount) {
        return false;
    }

    @Override
    public void deposit(Currency currency, double amount) {

    }

    public double getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(double stockBalance) {
        this.stockBalance = stockBalance;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getLoss() {
        return loss;
    }

    public void setLoss(double loss) {
        this.loss = loss;
    }

    //todo
    public double checkUnrealizedGain(){
        return 0;
    }

    //todo
    public double checkLoss() {
        return 0;
    }

    //todo
    public double buyTrade(Stock stock, double amount){
        return 0;
    }

    //todo
    public double sellTrade(Stock stock, double amount){
        return 0;
    }

    //todo
    public void openPosition(){

    }
}
