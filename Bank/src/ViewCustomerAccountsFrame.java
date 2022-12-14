import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
//        get account list info
//        need modify
//        for (here need to add list of account) {
//            String accountType = "";
//            if(account.getType() == AccountType.SAVING)
//                accountType = "Savings Account";
//            else if(account.getType() == AccountType.CHECKING)
//                accountType = "Checking Account";
//            else if(account.getType() == AccountType.STOCK)
//                accountType = "Stock Account";
//            System.out.println(account);
//            idField.append("" + func(here need to get account id) + "\n\n");
//            accountField.append(accountType + "\n\n");
//            balanceField.append("" + func(here need to get account deposit) + "\n\n");
//            currencyField.append("" + func(here need to get account currency) + "\n\n");
//            dateField.append("" + func(here need to get account OpenDate) + "\n\n");
//        }

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
