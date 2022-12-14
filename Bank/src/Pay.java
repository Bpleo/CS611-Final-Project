import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

public class Pay extends JFrame {

    private JButton cancelButton;
    private JTextField receiver;
    private JTextField amount;
    private JComboBox<String> accountsList;
    private JButton payButton;
    private JPanel PayPanel;

    private int getReceiver(){
        return Integer.valueOf(receiver.getText());
    }
    private double getamount(){
        return Double.parseDouble(amount.getText());
    }

    public Pay(Customer user){

        setContentPane(PayPanel);
        setTitle("View Accounts Form");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
//        TODO
//        get list of user accounts through userid
//        new account, make it = accounts in list
//        for(Account account : accounts){
//            if(account.getType()== AccountType.CHECKING || account.getType()== AccountType.SAVING){
//                accountsList.addItem( here need to get account id to string);
//            }
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
        receiver.addKeyListener(new KeyAdapter() {
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

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(receiver.getText().isEmpty()){
                    JOptionPane.showMessageDialog(PayPanel, "Please enter the receiver ID");
                }
                else if(amount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(PayPanel, "Please enter the deposit amount");
                }
//                TODO
//                else if(Integer.parseInt(receiver.getText().toString()) > here need the size of accounts, like the amount of the accouts || Integer.parseInt(receiver.getText().toString()) <= 1){
//                    JOptionPane.showMessageDialog(PayPanel, "User index out of range");
//                }
                else {
//                    TODO
//                    get list of accounts
//                    new account, make it = accounts in list(below)
//                    for (Account account : accounts) {
//                        if ( need to compare the account Id with: accountsList.getSelectedItem().toString())) {
//                            if( need to check whether the account could transfer money, and here need the parameters:getReceiver(), getamount()) {
//                                save accounts info to CSV
//                                save transactions info to CSV
//                                JOptionPane.showMessageDialog(PayPanel, "Amount paid!");
//                                break;
//                            }
//                            else{
//                                JOptionPane.showMessageDialog(PayPanel, "The receiver does not have a checking account!");
//                                break;
//                            }
//                        }
//                    }
                    dispose();
                }
            }
        });

    }

}
