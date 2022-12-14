import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = String.valueOf(passwordField.getPassword());

            if(userText.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter a username");
            }
            else if(pwdText.length() == 0){
                JOptionPane.showMessageDialog(this, "Please enter a password");
            }
//            TODO
//            else if(!Objects.equals( *.checkUserExist(userText), pwdText)){
//            comment: * here could be a class, provides the func checkUserExist, this func check if input username exist in database
//                     return password if user in the database, empty otherwise. so it can use 'Objects.equals' to compare with the pwdText
//                JOptionPane.showMessageDialog(this, "Invalid username or password");
//                reset();
//            }
            else{
//                TODO
//                need class login, the class includes string userText and pwdText
//                if( check wheather the user is empty ){
//                    JOptionPane.showMessageDialog(this, "No user found, Please create an account");
//                }else if( check if the pwd equals to the input pwd so it can run ){
//                    if( if the usertype is customer ){
//                        JOptionPane.showMessageDialog(this, "Customer Login Successful");
//                        dispose();
//                        new CustomerMainMenuFrame(userText);
//                    }else{
//                        JOptionPane.showMessageDialog(this, "Manager Login Successful");
//                        dispose();
//                        new ManagerAccountFrame(userText);
//                    }
//                }
            }

        }

        //showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            reset();
        }

    }
}
