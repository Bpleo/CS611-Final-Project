import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

public class Withdraw extends JFrame {

    private JTextField amount;
    private JButton cancelButton;
    private JButton withdrawButton;
    private JPanel WithdrawPanel;
    private JComboBox<String> checking;

    private double getWithdraw(){
        return Double.parseDouble(amount.getText());
    }

    public Withdraw(Customer user){
        setContentPane(WithdrawPanel);
        setTitle("View Accounts Form");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
//        TODO
//        get list of user accounts through user id
//        new account, make it = accounts in list(belwo
//        for(Account account : accounts){
//            if(account.getType()== AccountType.CHECKING){
//                checking.addItem( here need to get account id );
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

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(withdrawButton.getText().isEmpty()){
                    JOptionPane.showMessageDialog(WithdrawPanel, "Please enter the deposit amount");
                }
                else{
//                    TODO
//                    get list of accounts
//                    new account, make it = accounts in list(below)
//                    for(Account account: accounts){
//                        if( need to compare accounts Id with checking.getSelectedItem().toString())){
//                            if( accounts deposit amount < getWithdraw()){
//                                JOptionPane.showMessageDialog(WithdrawPanel, "Not enough balance");
//                            }
//                            else {
//                                update the account which can withdraw
//                                save accounts info to CSV
//                                JOptionPane.showMessageDialog(WithdrawPanel, "Amount Withdrawn!");
//                                dispose();
//                            }
//                            break;
//                        }
//                    }
                }
            }
        });

    }

}
