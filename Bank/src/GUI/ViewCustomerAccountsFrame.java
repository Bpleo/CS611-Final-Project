package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCustomerAccountsFrame extends JFrame {
    private JPanel viewAccountsPanel;
    private JButton backButton;
    private JLabel userIDLabel;
    private JTextArea accountsInfo;
    private JTextArea idField;
    private JTextArea accountField;
    private JTextArea balanceField;
    private JTextArea currencyField;
    private JTextArea dateField;


    public ViewCustomerAccountsFrame(int userID){
        setTitle("Customer Accounts");
        setContentPane(viewAccountsPanel);//cannot be null
        setResizable(true);
        setVisible(true);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        userIDLabel.setText(String.valueOf(userID));

        //TODO:add account list and show it


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        ViewCustomerAccountsFrame frame=new ViewCustomerAccountsFrame(1);
        frame.setTitle("Customer Accounts");
        frame.setLocation(10,10);
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
