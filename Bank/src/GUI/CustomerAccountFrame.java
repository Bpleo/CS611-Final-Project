package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAccountFrame extends JFrame implements ActionListener {
    private final String username;
    private final Container container;
    private final JLabel userLabel;
    private final JButton accountButton;
    private final JButton checkTransactionButton;
    private final JButton profileButton;
    private final JButton createAccountButton;
    private final JButton closeAccountButton;
    private final JButton loanButton;
    private final JButton makeTransactionButton;
    private final JButton logoutButton;
    private final JButton stockButton;
    private int customerID;

    public CustomerAccountFrame(String username) {
        setTitle("Customer Account");
        setVisible(true);
        setBounds(10,10,1000,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        container = getContentPane();
        userLabel = new JLabel();
        accountButton = new JButton("Check your accounts");
        checkTransactionButton = new JButton("View transactions");
        profileButton = new JButton("Profile");
        createAccountButton = new JButton("Create a checkings/savings/stock account");
        closeAccountButton = new JButton("Close Account");
        loanButton = new JButton("Manage Loans");
        makeTransactionButton = new JButton("Make transaction");
        logoutButton = new JButton("Logout");
        stockButton = new JButton("Stock");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        this.username = username;
        userLabel.setText("Username: " + this.username);
    }



    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(700, 100, 200, 50);
        profileButton.setBounds(300, 250, 400, 40);
        accountButton.setBounds(300, 300, 400, 40);
        checkTransactionButton.setBounds(300, 350, 400, 40);
        createAccountButton.setBounds(300, 400, 400, 40);
        closeAccountButton.setBounds(300, 450, 400, 40);
        loanButton.setBounds(300, 500, 400, 40);
        makeTransactionButton.setBounds(300, 550, 400, 40);
        logoutButton.setBounds(700, 650, 100, 35);
        stockButton.setBounds(300,600,400,40);

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(profileButton);
        container.add(accountButton);
        container.add(checkTransactionButton);
        container.add(createAccountButton);
        container.add(closeAccountButton);
        container.add(loanButton);
        container.add(makeTransactionButton);
        container.add(logoutButton);
        container.add(stockButton);
    }

    public void addActionEvent() {
        profileButton.addActionListener(this);
        accountButton.addActionListener(this);
        checkTransactionButton.addActionListener(this);
        createAccountButton.addActionListener(this);
        closeAccountButton.addActionListener(this);
        loanButton.addActionListener(this);
        makeTransactionButton.addActionListener(this);
        logoutButton.addActionListener(this);
        stockButton.addActionListener(this);
    }

//TODO
    @Override
    public void actionPerformed(ActionEvent e) {

    }

//Preview
    public static void main(String[] args){
        CustomerAccountFrame frame=new CustomerAccountFrame("1");
        frame.setTitle("Customer Account");
        frame.setLocation(10,10);
        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}