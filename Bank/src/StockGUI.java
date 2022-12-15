import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class StockGUI extends JFrame {

    private JPanel Stock;
    private JTextArea holdStocks;
    private JTextArea stockList;
    private JTextField stockName;
    private JButton buyButton;
    private JButton sellButton;
    private JLabel stockAmount;
    private JTextField amount;
    private JButton cancelButton;

    private int getAmount(){
        return Integer.valueOf(amount.getText());
    }
    private String getStockname() { return stockName.getText();}

    public StockGUI(int user) {
        setContentPane(Stock);
        setTitle("Stock");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        SecurityAccount stockAccount = getStockAccount(user + "");
        List<Stock> stockHoldList;
        if(stockAccount != null) {
//            TODO
//            stockHoldList = stockAccount.  here need the stock order history
//            for (Stock stock : stockHoldList) {
//                holdStocks.append( here need stocks name + " " + here need stocks amount + "\n\n");
//            }
        }
        else{
            JOptionPane.showMessageDialog(Stock, "Please create a stock account");
            dispose();
        }
//        TODO
//        get list of stocks
//        new stock, make it = stock in list(below)
//        for(Stock stock:List){
//            stockList.append( here need stocks name + " "+ here need stocks price()+ "\n\n");
//        }
        amount.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
                    getToolkit().beep();
                    e.consume();
                }
                super.keyTyped(e);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecurityAccount stockAccount = getStockAccount(user + "");
//                TODO
//                get the list of stocks
                if(stockName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Stock, "Please enter the stock name");
                }
                else {
                    int flag = 0;
//                    new stock, make it = stocks in list
//                    for (Stock stock : stocks) {
//                        if (stockName.getText().toString() whether equals to the stock name)) {
//                            if ( here do the operator buy stock, also need the parameters:getStockname(), getAmount() func above) {
//                                JOptionPane.showMessageDialog(Stock, "Stocks purchased!");
//                                flag = 1;
//                                dispose();
//                            }
//                            else{
//                                JOptionPane.showMessageDialog(Stock, "Not enough balance");
//                                flag = 1;
//                            }
//                            break;
//                        }
//                    }
                    if(flag == 0)
                        JOptionPane.showMessageDialog(Stock, "Please enter a valid stock name");
                }

            }
        });

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecurityAccount stockAccount = getStockAccount(user + "");

                if(amount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Stock, "Please enter the stock amount");
                }
                else if(stockName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(Stock, "Please enter the stock name");
                }
//                TODO
//                else if( here do the operator sell stock, alse need the parameters:getStockname(),getAmount() func above){
//                    JOptionPane.showMessageDialog(Stock, "Sold!");
//                    dispose();
//                }
            }
        });


    }

    private SecurityAccount getStockAccount(String userName) {
        /*
        Get list of Customer accounts through username
        new account, make it = accounts in list
        Returns the Security account from among the users accounts
         */
        SecurityAccount stockAccount = null;

        // Fetch the customer
        Customer customer = (Customer) FileHandler.checkUser(userName);

        for (Account account : customer.getAccounts()){
            if(account instanceof SecurityAccount){
                stockAccount = (SecurityAccount) account;
                return stockAccount;
            }
        }


        return stockAccount;
    }

    public static void main(String[] args){
        StockGUI frame=new StockGUI(1);
        frame.setTitle("Stock Portfolio");
        frame.setLocation(10,10);
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
