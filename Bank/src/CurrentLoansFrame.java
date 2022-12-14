import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CurrentLoansFrame extends JFrame {
    private JTextArea loanId;
    private JTextArea collateral;
    private JTextArea loanAmt;
    private JTextArea roi;
    private JTextArea currency;
    private JButton repayLoanButton;
    private JButton backButton;
    private JLabel loanIdField;
    private JPanel currentLoansPanel;
    private JLabel collateralField;
    private JLabel roiField;
    private JLabel currencyField;
    private JLabel loanAmtField;
    private JLabel currentLoans;

    public CurrentLoansFrame(int userID) {
        setTitle("Loan Accounts");
        setContentPane(currentLoansPanel);
        setResizable(true);
        setVisible(true);
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        currentLoans.setFont(new Font("Serif", Font.BOLD, 20));

//        TODO
//        get user loan accounts through the userid
//        for ( new loan and make it = list) {
//            loanId.append("" + func(here need to get Loan Id and made it toString) + "\n\n");
//            collateral.append( func(here need to get loan's tCollateral) + "\n\n");
//            loanAmt.append("" + func(here need to get loan's Amount) + "\n\n");
//            currency.append("" + func(here need to get loan's Currency) + "\n\n");
//            roi.append("" + func(here need to get loan's interest) + "\n\n");
//        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        repayLoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                TODO
//                if(check whether the list is empty)
//                    JOptionPane.showMessageDialog(currentLoansPanel, "You don't have any loans");
//                else
//                    new RepayLoan(userID);
//                dispose();
            }
        });
    }

}
