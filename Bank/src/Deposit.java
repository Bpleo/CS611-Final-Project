import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

public class Deposit extends JFrame {

    private JPanel DepositPanel;
    private JTextField depositAmount;
    private JButton cancelButton;
    private JButton depositButton;
    private JComboBox<String> checking;

    public Deposit(Customer user){
        setContentPane(DepositPanel);
        setTitle("View Accounts Form");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
//        TODO
//        need to get listof user accounts through userid
//        new account, make it = accounts in the list
//        for(Account account : accounts){
//            if(account.getType()== AccountType.CHECKING){
//                checking.addItem( here need to get accounts Id);
//            }
//        }

        depositAmount.addKeyListener(new KeyAdapter() {
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

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(depositAmount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(DepositPanel, "Please enter the deposit amount");
                }
                else if(getDeposit() < 100.0){
                    JOptionPane.showMessageDialog(DepositPanel, "Deposit cannot less than 100");
                }else{
//                    TODO
//                    need to get list of accounts
//                    new account, make it = accounts in the list
//                    for(Account account: accounts){
//                        if(compare the account id with checking.getSelectedItem().toString()){
//                            make the account deposit money, Update the corresponding data, need to use getDeposit() func below
//                            break;
//                        }
//                    }
//                    save accounts info to csv
                    JOptionPane.showMessageDialog(DepositPanel, "Amount deposited!");
                    dispose();
                }
            }
        });
    }

    //get  deposit
    private double getDeposit(){
        return Double.parseDouble(depositAmount.getText().toString());
    }

    public static void main(String[] args) {
        Customer user = new Customer("misaki", "l", 1);
        Deposit c = new Deposit(user);
    }

}
