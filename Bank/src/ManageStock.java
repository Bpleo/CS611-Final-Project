import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ManageStock extends JFrame {

    private JTextField price;
    private JTextField stockName;
    private JButton addButton;
    private JButton cancelButton;
    private JPanel ManageStock;
    private JTextArea stockList;

    private double getPrice(){
        return Double.parseDouble(price.getText());
    }
    private String getStockname() { return stockName.getText();}

    public ManageStock(){
        setContentPane(ManageStock);
        setTitle("Manage Stock");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

//        TODO
//        get the list of stocks
//        new stock here, make it = stocks in list(below)
//        for(Stock stock : List){
//            stockList.append( here need stocks name + " "+ here need stocks price + "\n\n");
//        }


        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                TODO
//                here need do the operator to add stock, also need to use the parameters: getStockname(),getPrice() funcs above
//                get the list of current stock list info
//                save current stock list info to CSV
                JOptionPane.showMessageDialog(ManageStock, "stock added");
                dispose();
            }
        });
    }

}
