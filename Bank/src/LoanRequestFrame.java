import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoanRequestFrame extends JFrame {

    private JTextField loanAmount;
    private JTextField collateralAmount;
    private JLabel loanAmountField;
    private JLabel currencyField;
    private JLabel collateralType;
    private JLabel collateralAmountField;
    private JComboBox comboBoxCurrency;
    private JPanel loanRequestPanel;
    private JTextField collateral;
    private JButton requestLoanButton;
    private JButton backButton;
    private JLabel loanRequest;

    public LoanRequestFrame(Customer user){
        setTitle("Loan Request Form");
        setContentPane(loanRequestPanel);
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loanRequest.setFont(new Font("Serif", Font.BOLD, 20));
        comboBoxCurrency.addItem(CurrencyType.CNY);
        comboBoxCurrency.addItem(CurrencyType.INR);
        comboBoxCurrency.addItem(CurrencyType.USD);

        loanAmount.addKeyListener(new KeyAdapter() {
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

        collateralAmount.addKeyListener(new KeyAdapter() {
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

        loanAmount.addKeyListener(new KeyAdapter() {
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

        collateralAmount.addKeyListener(new KeyAdapter() {
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

        requestLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loanAmt = loanAmount.getText();
                String collateralAmt = collateralAmount.getText();
                String collateralType = collateral.getText();
                if(loanAmt.isEmpty()){
                    JOptionPane.showMessageDialog(loanRequestPanel, "Please enter the loan Amount");
                }
                else if(collateralType.isEmpty()){
                    JOptionPane.showMessageDialog(loanRequestPanel, "Please enter the type of collateral");
                }
                else if(collateralAmt.isEmpty()){
                    JOptionPane.showMessageDialog(loanRequestPanel, "Please enter the collateral amount");
                }
                else if(Double.parseDouble(loanAmt) > Double.parseDouble(collateralAmt)){
                    JOptionPane.showMessageDialog(loanRequestPanel, "You cannot request loan greater than the collateral amount");
                }
                else{
//                    TODO
//                    create loan account, need (userId, Loan's Interest, collateralType, loan's amount, getCurrency:func below)
//                    need save the loan account info to disk (csv file)
//                    JOptionPane.showMessageDialog(loanRequestPanel, "Loan Approved!");
//                    dispose();
                }
            }
        });
    }

    //TODO:get input currency
    private void getCurrency(){

//        if(comboBoxCurrency.getSelectedItem() == CurrencyType.USD){
//            currency = USD
//        }else if(comboBoxCurrency.getSelectedItem() == CurrencyType.CNY){
//            currency = CNY
//        }else if(comboBoxCurrency.getSelectedItem() == CurrencyType.INR){
//            currency = KRW.
//        }
//        return currency;
    }

}
