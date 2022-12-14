package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewTransactionsInfo extends JFrame {

    private JTextArea dateField;
    private JTextArea amountField;
    private JTextArea memoField;
    private JButton backButton;
    private JPanel transactionPanel;
    private JTextArea userIdField;

//    TODO
//    public ViewTransactionsInfo( here need to add list of transaction){
//        setTitle("TransactionsInfo");
//        setContentPane(transactionPanel);
//        setResizable(true);
//        setVisible(true);
//        setSize(1000, 800);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        transactionPanel.setAutoscrolls(true);
//
//        for (Transaction transaction : transactions) {
//            System.out.println(transaction);//test
//            userIdField.append( here need func(need to get this transaction's user Id) + "\n\n");
//            memoField.append( here need func(need to get this transaction's logs) + "\n\n");
//            amountField.append("" + here need func(need to get this transaction's total amount) + "\n\n");
//            dateField.append("" + here need func(need to get this transaction's openDate) + "\n\n");
//        }
//
//        backButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//    }

}
