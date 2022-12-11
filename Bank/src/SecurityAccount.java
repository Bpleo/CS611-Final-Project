import java.util.ArrayList;
import java.util.Currency;

public class SecurityAccount extends Account{
    private double stockBalance;
    private double profit;
    private double loss;
    private ArrayList<Stock> stockListOwned;

    public SecurityAccount(int accountId, Customer customerId) {
        super(AccountType.SECURITY, accountId, customerId);
        setLoss(0);
        setProfit(0);
        setStockBalance(0);
        stockListOwned = new ArrayList<Stock>();
    }
    public boolean withdraw(CurrencyType currencyType, double amount) {
        /*
        Method used to withdraw money from stockBalance
        Checks for sufficient balance
         */

        if (stockBalance > amount){
            stockBalance -= amount;
            return true;
        }


        return false;
    }

    public void deposit(CurrencyType currency, double amount) {
        /*
        Method used to deposit money to stockBalance
         */

        if (amount > 0){
            stockBalance += amount;
        }

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

    public double getStockHoldingValue() {
        /*
        This method calculates the total value of stocks held in portfolio.
        This is done by looping through all the stocks.
        Then it is multiplied stock price by quantity to add up holding value.
         */
        double holding=0;

        // Loop through the list of stocks owned
        for (Stock stock: stockListOwned){
            // Calculate as price of stock times the quantity of the stock
            holding += stock.getStockPrice() * stock.getStockQuantity();
        }

        return holding;

    }

    public double getUnrealizedGain(){
        /*
        This method calculates the total increase in value of stocks held in portfolio,
        from their original buying price.
        This is done by looping through all the stocks.
        Then gain/loss of each stock is calculated and added up.
         */
        double unrealizedGains=0;

        // Loop through the list of stocks owned
        for (Stock stock: stockListOwned){
            // Calculate as current price of stock subtracted by buy price
            unrealizedGains += stock.getStockPrice() - stock.getStockBuyPrice();
        }

        return unrealizedGains;
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
