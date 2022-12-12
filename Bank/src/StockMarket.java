import java.util.*;

public class StockMarket {

    // Stock Market listed stocks are publicly available information
    public static ArrayList<Stock> stockMarketList;

    public ArrayList<Stock> getStockMarketList(){
        /*
        Method returns list of stock in stock market
        */

        return stockMarketList;
    }

    public boolean addStockToMarket(Stock stock){
        /*
        This method takes a stock as argument.
        Check if stock already present in stockMarket,
        If not, add it.
        */

        // Loop through the stocks list in stock market
        for (Stock marketStock: stockMarketList) {

            // If stock already present, return false
            if (marketStock.getStockId() == stock.getStockId()) {
                return false;
            }
        }

        // Add the new stock to the stock market
        stockMarketList.add(stock);

        return true;
    }

    public boolean removeStockFromMarket(Stock stock){
        /*
        This method takes a stock as argument.
        if stock present in stockMarket, remove it.
        */

        // Loop through the stocks list in stock market
        for (Stock marketStock: stockMarketList) {

            // If stock present, remove it and return true
            if (marketStock.getStockId() == stock.getStockId()) {

                stockMarketList.remove(marketStock);
                return true;
            }
        }


        return false;
    }

}
