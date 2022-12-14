import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class CreateAccountFrame extends JFrame {
    private JPanel createAccountPanel;
    private JComboBox<AccountType> comboBoxAccountType;//here is Drop-down list box
    private JComboBox<CurrencyType> comboBoxCurrencyType;//here is Drop-down list box
    private JButton createAccountButton;
    private JTextField InitialDepositTextField;
    private JLabel createAccount;
    private JButton backButton;

    //TODO
    //need change this customer class to user class
    public CreateAccountFrame(Customer user){
        setTitle("Create Account Form");
        setContentPane(createAccountPanel);
        setTitle("Create Account Form");
        setVisible(true);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        createAccount.setFont(new Font("Serif", Font.BOLD, 20));
        comboBoxAccountType.addItem(AccountType.CHECKING);
        comboBoxAccountType.addItem(AccountType.SAVING);
        comboBoxAccountType.addItem(AccountType.SECURITY);
        comboBoxAccountType.addItem(AccountType.LOAN);

        comboBoxCurrencyType.addItem(CurrencyType.CNY);
        comboBoxCurrencyType.addItem(CurrencyType.INR);
        comboBoxCurrencyType.addItem(CurrencyType.USD);
        comboBoxCurrencyType.addItem(CurrencyType.GBP);

        //only input should be number
        InitialDepositTextField.addKeyListener(new KeyAdapter() {
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("test"+comboBoxCurrencyType.getSelectedItem());

                if(InitialDepositTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(createAccountPanel, "Please add an initial deposit amount");
                }
                else if(getDeposit() < 100.0){
                    JOptionPane.showMessageDialog(createAccountPanel, "Initial Deposit cannot less than 100");
                }
//                TODO
//                else if(comboBoxAccountType.getSelectedItem()== AccountType.SECURITY){
//                    add account lsit from the id
//                    check saving account from the list
//                    if( the output of checking the saving account ==null){
//                        JOptionPane.showMessageDialog(createAccountPanel, "You don't have a saving account. You must have more than $5000 in your saving account");
//
//                    } else if(here need to check thr saving's deposit Amount >5000){
//                        here can create new account about the stock (userid,deposit,getCurrency(func below),(AccountType) comboBoxAccountType.getSelectedItem())
//                        get all the new account info
//                        JOptionPane.showMessageDialog(createAccountPanel, "Account Created!");
//                        need to add a withdraw fee when create a new stock account
//                        dispose();
//                    }else{
//                        JOptionPane.showMessageDialog(createAccountPanel, "You must have more than $5000 in your saving account");
//                    }
//                } else{
//                    here can create new account about the saving/checking  (userid, deposit,getCurrency(func below),(AccountType) comboBoxAccountType.getSelectedItem())
//                    get all the new account info
//                    JOptionPane.showMessageDialog(createAccountPanel, "Account Created!");
//                    dispose();
//                }
            }
        });
    }

    //get start deposit
    private double getDeposit(){
        return Double.parseDouble(InitialDepositTextField.getText());
    }

    //TODO:get input currency
//    private void getCurrency(){
//        if(comboBoxCurrencyType.getSelectedItem() == CurrencyType.USD){
//            make currency = USD
//        }else if(comboBoxCurrencyType.getSelectedItem() == CurrencyType.CNY){
//            make urrency = CNY
//        }else if(comboBoxCurrencyType.getSelectedItem() == CurrencyType.KRW){
//            make currency = KRW
//        }
//        return currency;
//
//    }

    public static void main(String[] args) {
        Customer user = new Customer("miaki", "l", 1,"Longdan","Mao");
        CreateAccountFrame c = new CreateAccountFrame(user);
    }
}
