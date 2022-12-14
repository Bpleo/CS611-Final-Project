import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerList extends JFrame {

    private JComboBox comboBoxUserId;
    private JButton continueButton;
    private JPanel customerListPanel;
    private JButton backButton;
//    private List<User> users; need the user class

    public CustomerList() {
        setTitle("Select Customer");
        setContentPane(customerListPanel);
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//        TODO
//        get the user info
//        for(new user, make it = user in the list){
//            if( need to compare the user type with the type MANAGER)
//                continue;
//            comboBoxUserId.addItem( here need the user id );
//        }

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBoxUserId.getSelectedItem());
                new ViewCustomerAccountsFrame(Integer.parseInt(comboBoxUserId.getSelectedItem().toString()));
            }
        });
    }

    public static void main(String[] args) {
        CustomerList c = new CustomerList();
        //Account.Account.AccountType t = (Account.AccountType) c.comboBoxAccountType.getSelectedItem();

    }

}
