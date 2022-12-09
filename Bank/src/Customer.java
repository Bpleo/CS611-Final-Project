import java.util.*;

public class Customer {
    private String customerName;
    private String pwd;
    private int customerId;
    private ArrayList<Account> accounts;

    public Customer(String name, String pwd, int id){
        customerName = name;
        this.pwd = pwd;
        customerId = id;
        accounts = new ArrayList<>();
    }
}
