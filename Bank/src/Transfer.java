import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Objects;

public class Transfer extends JFrame {

    private JComboBox<String> withdrawAccount;
    private JComboBox<String> depositAccount;
    private JButton transferButton;
    private JButton cancelButton;
    private JTextField amount;
    private JPanel transferPanel;

    private double getAmount(){
        return Double.parseDouble(amount.getText());
    }

    public Transfer(Customer user){

        setContentPane(transferPanel);
        setTitle("Transfer");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
//        TODO
//        get the list of user accounts through userId()
//        new account, make it = accounts in list(below)
//        for(Account account : accounts){
//            withdrawAccount.addItem(account.getType().toString());
//            depositAccount.addItem(account.getType().toString());
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

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(amount.getText().isEmpty()){
                    JOptionPane.showMessageDialog(transferPanel, "Please enter the deposit amount");
                }
                Account in = null;
                Account out= null;
//                TODO
//                new account, make it = accounts in list(below)
//                for(Account account : accounts){
//                    if(account.getType().toString().equals(withdrawAccount.getSelectedItem())){
//                        out = account;
//                    }else if(account.getType().toString().equals(depositAccount.getSelectedItem())){
//                        in = account;
//                    }
//                }

                Account inAcc = null;
                Account outAcc= null;
//                TODO
//                get list of all accounts
//                new account, make it =  accounts in list(below)
//                for(Account account : accounts){
//                    if(check the account id whether = the out account id){
//                        outAcc = account;
//                    }else if(check the account id whether =the in account id){
//                        inAcc = account;
//                    }
//                }
                if(outAcc != null && inAcc != null) {
                    if(inAcc instanceof SecurityAccount){
                        if(getAmount()>=1000){
//                            TODO
//                            outacc need to transfer this amount money
//                            save all accounts info to CSV
                            JOptionPane.showMessageDialog(transferPanel, "Amount transferred!");
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(transferPanel, "Amount must over 1000!");
                            dispose();
                        }
                    }else{
//                        TOOD
//                        outacc need to transfer this amount money
//                        save all accounts info to CSV
//                        save all transactions info to CSV
                        JOptionPane.showMessageDialog(transferPanel, "Amount transferred!");
                        dispose();
                    }
                }

            }
        });

    }

}
