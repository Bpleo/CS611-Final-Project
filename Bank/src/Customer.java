import java.util.*;

public class Customer {
    private static String customerName;
    private static int customerId;
    private ArrayList<Account> accounts;

    public Customer(String name, int id){
        customerName = name;
        customerId = id;
        accounts = new ArrayList<>();
    }
}
