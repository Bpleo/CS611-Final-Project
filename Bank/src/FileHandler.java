import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

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
        readChecking();
        readSaving();
        readLoan();
        readSecurity();
        readCustomer();
    }

    private void readChecking(){
        try{
            Scanner in = new Scanner(new File(dirPath + "checking.csv"));
            while (in.hasNext()){
                String[] info = in.nextLine().split(",");
                int cId = Integer.parseInt(info[0]);
                int aId = Integer.parseInt(info[1]);
                CheckingAccount tempC = new CheckingAccount(aId, cId);
                for (int i = 2; i < info.length; i+=2){
                    tempC.deposit(CurrencyType.valueOf(info[i]),Double.parseDouble(info[i+1]));
                }
                checkingAccountList.add(tempC);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void readSaving(){
        try{
            Scanner in = new Scanner(new File(dirPath + "saving.csv"));
            while (in.hasNext()){
                String[] info = in.nextLine().split(",");
                int cId = Integer.parseInt(info[0]);
                int aId = Integer.parseInt(info[1]);
                double interestRate = Double.parseDouble(info[2]);
                SavingAccount tempS = new SavingAccount(aId, cId);
                tempS.setInterestSaving(interestRate);
                for (int i = 3; i < info.length; i+=3){
                    CurrencyType tempC = CurrencyType.valueOf(info[i]);
                    double amount = Double.parseDouble(info[i+1]);
                    LocalDate depositDate = LocalDate.parse(info[i+2]);
                    SavingDeposit tempSd = new SavingDeposit(depositDate,amount);
                    tempS.deposit(tempC,tempSd);
                }
                savingAccountList.add(tempS);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void readLoan(){
        try{
            Scanner in = new Scanner(new File(dirPath + "loan.csv"));
            while (in.hasNext()){
                String[] info = in.nextLine().split(",");
                //Create Account
                int cId = Integer.parseInt(info[0]);
                int aId = Integer.parseInt(info[1]);
                LoanAccount tempL = new LoanAccount(aId,cId);
                //Fill in attribute
                double rate = Double.parseDouble(info[2]);
                double amount = Double.parseDouble(info[3]);
                CurrencyType type = CurrencyType.valueOf(info[4]);
                LocalDate loanDate = LocalDate.parse(info[5]);
                LocalDate paidDate = LocalDate.parse(info[6]);
                tempL.requestLoan(amount,type,rate,DAYS.between(loanDate,paidDate),loanDate);
                //Add to list
                loanAccountList.add(tempL);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void readSecurity(){

    }

    private void readCustomer(){
        try{
            Scanner in = new Scanner(new File(dirPath + "customer.csv"));
            while(in.hasNext()){
                String[] info = in.nextLine().split(",");
                int id = Integer.parseInt(info[0]);
                Customer tempC = new Customer(info[1],info[2],id);
                loadAccounts(tempC);
                customerList.add(tempC);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void loadAccounts(Customer customer){
        for (int i = 0; i < checkingAccountList.size(); i++)
            if (checkingAccountList.get(i).getCustomerId() == customer.getCustomerId())
                customer.addAccount(checkingAccountList.get(i));
        for (int i = 0; i < savingAccountList.size(); i++)
            if (savingAccountList.get(i).getCustomerId() == customer.getCustomerId())
                customer.addAccount(savingAccountList.get(i));
        for (int i = 0; i < loanAccountList.size(); i++)
            if (loanAccountList.get(i).getCustomerId() == customer.getCustomerId())
                customer.addAccount(loanAccountList.get(i));
        for (int i = 0; i < securityAccountList.size(); i++)
            if (securityAccountList.get(i).getCustomerId() == customer.getCustomerId())
                customer.addAccount(securityAccountList.get(i));
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
                out.println("," + tempA.getLoanAmount() + "," + tempA.getLoanType() + "," + tempA.getLoanDate() + "," + tempA.getPaidDate());
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private void writeSecurity(){
        try{
            File temp = new File(dirPath + "security.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < securityAccountList.size(); i++){
                SecurityAccount tempS = securityAccountList.get(i);
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }
}
