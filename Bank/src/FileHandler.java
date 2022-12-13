import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileHandler {
    private ArrayList<CheckingAccount> checkingAccountList;
    private ArrayList<SavingAccount> savingAccountList;
    private ArrayList<LoanAccount> loanAccountList;
    private ArrayList<SecurityAccount> securityAccountList;
    private ArrayList<Customer> customerList;
    private final String dirPath = "." + File.pathSeparator + "csvFile" + File.pathSeparator;

    public FileHandler(){
        checkingAccountList = new ArrayList<>();
        savingAccountList = new ArrayList<>();
        loanAccountList = new ArrayList<>();
        securityAccountList = new ArrayList<>();
        customerList = new ArrayList<>();
    }

    public void readFiles() {

    }

    public void writeFiles() {
        writeCustomer();
        writeChecking();
        writeSaving();
        writeLoan();
        writeSecurity();
    }

    private void writeCustomer() {
        try{
            File temp = new File(dirPath + "customer.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < customerList.size(); i++){
                Customer tempC = customerList.get(i);
                out.println(tempC.getCustomerId() + "," + tempC.getCustomerName() + "," + tempC.getPwd());
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void writeChecking() {
        try{
            File temp = new File(dirPath + "checking.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < checkingAccountList.size(); i++){
                CheckingAccount tempA = checkingAccountList.get(i);
                out.print(tempA.getCustomerId() + "," + tempA.getAccountId());
                for (CurrencyType c : CurrencyType.values()) {
                    out.print("," + c);
                    double deposit = tempA.getDeposit(c);
                    if (deposit == -1)
                        out.print(", ");
                    else
                        out.print("," + deposit);
                }
                out.println();
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void writeSaving() {
        try{
            File temp = new File(dirPath + "saving.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < savingAccountList.size(); i++){
                SavingAccount tempA = savingAccountList.get(i);
                out.print(tempA.getCustomerId() + "," + tempA.getAccountId() + "," + tempA.getInterestSaving());
                for (CurrencyType c : CurrencyType.values()) {
                    out.print("," + c);
                    double deposit = (tempA).getBalance(c);
                    LocalDate depositDate = (tempA).getDepositDate(c);
                    if (deposit == -1)
                        out.print(", , ");
                    else
                        out.print("," + deposit + "," + depositDate);
                }
                out.println();
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void writeLoan() {
        try{
            File temp = new File(dirPath + "loan.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < loanAccountList.size(); i++){
                LoanAccount tempA = loanAccountList.get(i);
                out.print(tempA.getCustomerId() + "," + tempA.getAccountId() + "," + tempA.getLoanInterest());
                out.println("," + tempA.getLoanAmount() + "," + tempA.getLoanDate() + "," + tempA.getPaidDate());
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void writeSecurity(){

    }
}
