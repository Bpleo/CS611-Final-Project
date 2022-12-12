package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    private final Container container;
    private final JLabel userLabel;
    private final JLabel passwordLabel;
    private final JTextField userTextField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton resetButton;
    private final JCheckBox showPassword;

    public LoginFrame() {
        setTitle("Login");
        setVisible(true);
        setLocation(10,10);
        setSize(1000,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);//User cannot resize the frame
        container = getContentPane();
        userLabel = new JLabel("USERNAME");
        passwordLabel = new JLabel("PASSWORD");
        userTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    private void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    private void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(300, 250, 100, 50);
        passwordLabel.setBounds(300, 400, 100, 50);
        userTextField.setBounds(550, 250, 150, 40);
        passwordField.setBounds(550, 400, 150, 40);
        showPassword.setBounds(550, 450, 150, 40);
        loginButton.setBounds(300, 500, 100, 40);
        resetButton.setBounds(600, 500, 100, 40);
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    public void reset() {
        userTextField.setText("");
        passwordField.setText("");
    }

//    TODO
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
