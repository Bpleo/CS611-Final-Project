import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class RepayLoan extends JFrame {

    private JLabel repayLoan;
    private JComboBox comboBoxLoanAccount;
    private JLabel dueAmt;
    private JTextField payment;
    private JButton confirmButton;
    private JButton backButton;
    private JLabel accountField;
    private JLabel dueAmtLabel;
    private JLabel paymentLabel;
    private JPanel repayLoanPanel;

    public RepayLoan(int userID) {
        setTitle("Repay Loan");
        setContentPane(repayLoanPanel);
        setResizable(true);
        setVisible(true);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        repayLoan.setFont(new Font("Serif", Font.BOLD, 20));

        payment.addKeyListener(new KeyAdapter() {
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

//        TODO
//        here need to get loan's accounts info
//        for(new loan, make it = loans' accounts info){
//            comboBoxLoanAccount.addItem( here need to get loan id, id is toString());
//        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

//        TODO
//        here need to get loan from ID, need to use func(comboBoxLoanAccount.getSelectedItem().toString())
//        get due amount = (1 + (loan's interest / 100)) * loan.getLoanAmount().getAmount();
//        dueAmt.setText(dueAmount.toString());
//        need to get loan's id
//        comboBoxLoanAccount.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Updating due amount based on selected account
//                here need to get loan from ID, need to use func(comboBoxLoanAccount.getSelectedItem().toString())
//                get due amount = (1 + (loan's getInterest() / 100)) * loan's amount
//                dueAmt.setText(dueAmount.toString());
//                need to get loan's id
//            }
//        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                TODO
//                here need to get list of user accounts through userID
                String pay = payment.getText();
                if(pay.isEmpty()){
                    JOptionPane.showMessageDialog(repayLoanPanel, "Please enter payment amount");
                }
//                TODO
//                else if(check accounts isEmpty){
//                    JOptionPane.showMessageDialog(repayLoanPanel, "Please create a checking account to make the payment");
//                    dispose();
//                }
                else{
                    Account curAccount = null;
//                    TODO
//                    new account , make it = accounts list(below)
//                    for(Account account: accounts list name ){
//                        if(account.getType() == AccountType.CHECKING) {
//                            curAccount = account;
//                            break;
//                        }
//                    }
                    if(curAccount == null) {
                        JOptionPane.showMessageDialog(repayLoanPanel, "Please create a checking account to make the payment");
                        dispose();
                    }
//                    TODO
//                    else if(Double.parseDouble(pay) > curAccounts deposit amount){
//                        JOptionPane.showMessageDialog(repayLoanPanel, "You don't have enough balance");
//                    }
                    else if(Double.parseDouble(pay) > Double.parseDouble(dueAmt.getText())){
                        JOptionPane.showMessageDialog(repayLoanPanel, "Please enter an amount less than the due amount");
                    }
                    else {
//                    TODO
//                    here need to get list of loans accounts
//                        new loan, make it = loans list(below)
//                        for (Loan loan : loans list){
//                            if (list of loans ID = this Id() ){
//                                amt = get loan 's amount - pay;   pay:Double.parseDouble(pay) from the gui' s text
//                                if (amt <= 0) {
//                                    remove loans
//                                    JOptionPane.showMessageDialog(repayLoanPanel, "Loan Cleared");
//                                } else
//                                    set loan 's new amount;
//                                break;
//                            }
//                        }
//                        TODO
//                        resetting accounts and loans with updated amounts
//                        reset current deposit = curAccount - pay
//                        save loan 's account to CSV
//                        save accounts info to CSV
                        JOptionPane.showMessageDialog(repayLoanPanel, "Payment successful");
                        dispose();
                    }

                }
            }
        });

    }
}
