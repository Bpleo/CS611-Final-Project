import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Deposit extends JFrame {

    private JPanel DepositPanel;
    private JTextField depositAmount;
    private JButton cancelButton;
    private JButton depositButton;
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


    public Deposit(Customer user){
        setContentPane(DepositPanel);
        setTitle("View Accounts Form");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        ArrayList<Account> accounts = user.getAccounts();
        for (Account account : accounts)
            accountList.addItem(account.getAccountId() + " " + account.getType());
        for (CurrencyType c : CurrencyType.values())
            currencyType.addItem(c);

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
                    long accountId = Long.parseLong(accountList.getSelectedItem().toString().split(" ")[0]);
                    for (Account account : accounts) {
                        if (account.getAccountId() == accountId)
                            account.deposit(getCurrency(),getDeposit());
                    }
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
//Preview
//    public static void main(String[] args) {
//        Customer user = new Customer("misaki", "l", 1,"Longdan","Mao");
//        Deposit c = new Deposit(user);
//    }

}
