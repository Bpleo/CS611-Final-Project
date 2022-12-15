import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Withdraw extends JFrame {

    private JTextField amount;
    private JButton cancelButton;
    private JButton withdrawButton;
    private JPanel WithdrawPanel;
    private JComboBox<String> accountList;
    private JComboBox<CurrencyType> currencyType;

    private CurrencyType getCurrency(){
        CurrencyType currency = null;
        if(currencyType.getSelectedItem() == CurrencyType.USD){
            currency = CurrencyType.USD;
        }else if(currencyType.getSelectedItem() == CurrencyType.CNY){
            currency = CurrencyType.CNY;
        }else if(currencyType.getSelectedItem() == CurrencyType.INR){
            currency = CurrencyType.INR;
        }else
            currency = CurrencyType.GBP;
        return currency;

    }

    private double getWithdraw(){
        return Double.parseDouble(amount.getText());
    }

    public Withdraw(Customer user){
        setContentPane(WithdrawPanel);
        setTitle("View Accounts Form");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        ArrayList<Account> accounts = user.getAccounts();
        for (Account account : accounts)
            accountList.addItem(account.getAccountId() + " " + account.getType());
        for (CurrencyType c : CurrencyType.values())
            currencyType.addItem(c);

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
                    long accountId = Long.parseLong(accountList.getSelectedItem().toString().split(" ")[0]);
                    for (int i = 0; i < accounts.size(); i++) {
                        if (accounts.get(i).getAccountId() == accountId) {
                            if (accounts.get(i).withdraw(getCurrency(), getWithdraw())) {
                                FileHandler.updateAccount(accounts.get(i));
                                JOptionPane.showMessageDialog(WithdrawPanel, "Amount Withdrawn!");
                                dispose();
                            }else {
                                JOptionPane.showMessageDialog(WithdrawPanel, "Not enough balance");
                            }
                        }
                    }
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
