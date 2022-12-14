import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class CloseAccount extends JFrame {
    private JComboBox accounts;
    private JButton closeAccountButton;
    private JPanel closeAccountPanel;
    private JLabel closeAccount;
    private JLabel selectField;
    private JButton backButton;

    //TODO:change customer to user class
    public CloseAccount(Customer user){
        setTitle("Close Account");
        setContentPane(closeAccountPanel);
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//        TODO
//        get the user account list through the userid
//        for( new account , make it = user account info){
//            accounts.addItem( here need to get account id );
//        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        closeAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                TODO
//                get the account list
//                for(new account , make it = account list){
//                    if( account's id = accounts' get_selectedID){
//                        remove this account from accountList
//                        Update the csv file that holds the account
//                        JOptionPane.showMessageDialog(closeAccountPanel, "Account closed");
//                        Bank manager can make Profit from here(?optional)
//                        add a transaction here bcz of the profit(?optional)
//                        dispose();
//                        break;
//                    }
//                }
            }
        });


    }
}
