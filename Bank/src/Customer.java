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

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void removeAccount(int accoundId){
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).getAccountId() == accoundId)
                accounts.remove(i);
        }
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
