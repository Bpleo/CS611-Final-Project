import java.util.ArrayList;

public class FileHandler {
    private ArrayList<CheckingAccount> checkingAccountList;
    private ArrayList<SavingAccount> savingAccountList;
    private ArrayList<LoanAccount> loanAccountList;
    private ArrayList<SecurityAccount> securityAccountList;
    private ArrayList<Customer> customerList;

    public FileHandler(){
        checkingAccountList = new ArrayList<>();
        savingAccountList = new ArrayList<>();
        loanAccountList = new ArrayList<>();
        securityAccountList = new ArrayList<>();
        customerList = new ArrayList<>();
    }
}
