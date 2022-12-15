import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.DAYS;

public class FileHandler {
    private static ArrayList<CheckingAccount> checkingAccountList = new ArrayList<>();
    private static ArrayList<SavingAccount> savingAccountList = new ArrayList<>();
    private static ArrayList<LoanAccount> loanAccountList = new ArrayList<>();
    private static ArrayList<SecurityAccount> securityAccountList = new ArrayList<>();
    private static ArrayList<User> userList = new ArrayList<>();
    //If run in terminal, change the front . to ..
    private static final String dirPath = "." + File.separator + "csvFile" + File.separator;
    public static void addUser(User user){
        userList.add(user);
        writeCustomer();
    }

    public static User checkUser(String userName){
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getUserName().equals(userName))
                return userList.get(i);
        return null;
    }

    public static User getUserById(int userId){
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i).getUserId() == userId)
                return userList.get(i);
        return null;
    }

    public static void addAccount(Account account){
        switch (account.getType()){
            case LOAN:
                loanAccountList.add((LoanAccount)  account);
                writeLoan();
                break;
            case SAVING:
                savingAccountList.add((SavingAccount) account);
                writeSaving();
                break;
            case CHECKING:
                checkingAccountList.add((CheckingAccount) account);
                writeChecking();
                break;
            case SECURITY:
                securityAccountList.add((SecurityAccount) account);
                writeSecurity();
                break;
        }
    }

    public static void removeAccount(Account account) {
        switch (account.getType()){
            case LOAN:
                for (int i = 0; i < loanAccountList.size(); i++)
                    if (loanAccountList.get(i).getAccountId() == account.getAccountId())
                        loanAccountList.remove(i);
                writeLoan();
                break;
            case SAVING:
                for (int i = 0; i < savingAccountList.size(); i++)
                    if (savingAccountList.get(i).getAccountId() == account.getAccountId())
                        savingAccountList.remove(i);
                writeSaving();
                break;
            case CHECKING:
                for (int i = 0; i < checkingAccountList.size(); i++)
                    if (checkingAccountList.get(i).getAccountId() == account.getAccountId())
                        checkingAccountList.remove(i);
                writeChecking();
                break;
            case SECURITY:
                for (int i = 0; i < securityAccountList.size(); i++)
                    if (securityAccountList.get(i).getAccountId() == account.getAccountId())
                        securityAccountList.remove(i);
                writeSecurity();
                break;
        }
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static ArrayList<CheckingAccount> getCheckingAccountList() {
        return checkingAccountList;
    }

    public static ArrayList<LoanAccount> getLoanAccountList() {
        return loanAccountList;
    }

    public static ArrayList<SavingAccount> getSavingAccountList() {
        return savingAccountList;
    }

    public static ArrayList<SecurityAccount> getSecurityAccountList() {
        return securityAccountList;
    }

    public static void readFiles() {
        readChecking();
        readSaving();
        readLoan();
        readStockMarket();
        readSecurity();
        readCustomer();
    }

    private static void readChecking(){
        try{
            Scanner in = new Scanner(new File(dirPath + "checking.csv"));
            while (in.hasNext()){
                String[] info = in.nextLine().split(",");
                int cId = Integer.parseInt(info[0]);
                int aId = Integer.parseInt(info[1]);
                CheckingAccount tempC = new CheckingAccount(aId, cId);
                for (int i = 2; i < info.length; i+=2){
                    if (!info[i+1].equals(" "))
                        tempC.deposit(CurrencyType.valueOf(info[i]),Double.parseDouble(info[i+1]));
                }
                checkingAccountList.add(tempC);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void readSaving(){
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
                    if (!(info[i+1].equals(" ") && info[i+2].equals(" "))) {
                        CurrencyType tempC = CurrencyType.valueOf(info[i]);
                        double amount = Double.parseDouble(info[i + 1]);
                        LocalDate depositDate = LocalDate.parse(info[i + 2]);
                        SavingDeposit tempSd = new SavingDeposit(depositDate, amount);
                        tempS.deposit(tempC, tempSd);
                    }
                }
                savingAccountList.add(tempS);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void readLoan(){
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

    private static void readStockMarket(){
        try{
            // Initialise Stock Market
            new StockMarket();

            Scanner in = new Scanner(new File(dirPath + "stockmarket.csv"));
            while (in.hasNext()){
                String[] info = in.nextLine().split(",");

                //Get attribute
                int sId = Integer.parseInt(info[0]);
                String name = info[1];
                double price = Double.parseDouble(info[2]);
                double buyPrice = Double.parseDouble(info[3]);
                int quantity = Integer.parseInt(info[4]);

                Stock tempStock = new Stock(sId,name,price,quantity);

                // Add the stock to stock market
                StockMarket.stockMarketList.add(tempStock);

            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void readSecurity(){
        try{
            Scanner in = new Scanner(new File(dirPath + "security.csv"));
            while (in.hasNext()){
                String[] info = in.nextLine().split(",");
                //Get attribute
                int cId = Integer.parseInt(info[0]);
                int aId = Integer.parseInt(info[1]);
                double stockBalance = Double.parseDouble(info[2]);
                double profit = Double.parseDouble(info[3]);
                double loss = Double.parseDouble(info[4]);
                //Fill in stocks owned
                ArrayList<Stock> stocks = new ArrayList<>();
                for (int i = 5; i < info.length; i+=5){
                    int sId = Integer.parseInt(info[i]);
                    String name = info[i+1];
                    double price = Double.parseDouble(info[i+2]);
                    double buyPrice = Double.parseDouble(info[i+3]);
                    int quantity = Integer.parseInt(info[i+4]);
                    Stock tempStock = new Stock(sId,name,price,quantity);
                    tempStock.setStockBuyPrice(buyPrice);
                    stocks.add(tempStock);
                }
                SecurityAccount tempS = new SecurityAccount(aId,cId,stockBalance,profit,loss,stocks);
                securityAccountList.add(tempS);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void readCustomer(){
        try{
            Scanner in = new Scanner(new File(dirPath + "customer.csv"));
            while(in.hasNext()){
                String[] info = in.nextLine().split(",");
                String type = info[0];
                int id = Integer.parseInt(info[1]);
                User tempC;
                if (type.equals("C")) {
                    tempC = new Customer(info[2], info[3], id,info[4],info[5]);
                    loadAccounts((Customer) tempC);
                }else
                    tempC = new BankManager(info[2],info[3],id);
                userList.add(tempC);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void loadAccounts(Customer customer){
        for (int i = 0; i < checkingAccountList.size(); i++)
            if (checkingAccountList.get(i).getCustomerId() == customer.getUserId())
                customer.addAccount(checkingAccountList.get(i));
        for (int i = 0; i < savingAccountList.size(); i++)
            if (savingAccountList.get(i).getCustomerId() == customer.getUserId())
                customer.addAccount(savingAccountList.get(i));
        for (int i = 0; i < loanAccountList.size(); i++)
            if (loanAccountList.get(i).getCustomerId() == customer.getUserId())
                customer.addAccount(loanAccountList.get(i));
        for (int i = 0; i < securityAccountList.size(); i++)
            if (securityAccountList.get(i).getCustomerId() == customer.getUserId())
                customer.addAccount(securityAccountList.get(i));
    }

    public static void writeFiles() {
        writeCustomer();
        writeChecking();
        writeSaving();
        writeLoan();
        writeStockMarket();
        writeSecurity();
    }

    private static void writeCustomer() {
        try{
            File temp = new File(dirPath + "customer.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < userList.size(); i++){
                User tempC = userList.get(i);
                if (tempC.getUserType().equals("M"))
                    out.println(tempC.getUserType() + "," + tempC.getUserId() + "," + tempC.getUserName() + "," + tempC.getUserPwd());
                else {
                    Customer tempCu = (Customer) tempC;
                    out.println(tempC.getUserType() + "," + tempC.getUserId() + "," + tempC.getUserName() + "," + tempC.getUserPwd() + "," + tempCu.getFirstName() +","+tempCu.getLastName());
                }
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void writeChecking() {
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

    private static void writeSaving() {
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

    private static void writeLoan() {
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

    private static void writeSecurity(){
        try{
            File temp = new File(dirPath + "security.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < securityAccountList.size(); i++){
                SecurityAccount tempS = securityAccountList.get(i);
                out.print(tempS.getCustomerId() + "," + tempS.getAccountId() + "," + tempS.getStockBalance());
                out.print("," + tempS.getProfit() + "," + tempS.getLoss());
                ArrayList<Stock> stocks = tempS.getStockListOwned();
                for (int j = 0; j < stocks.size(); j++){
                    out.print("," + stocks.get(j).getStockId() + "," + stocks.get(j).getStockName());
                    out.print("," + stocks.get(j).getStockPrice() + "," + stocks.get(j).getStockBuyPrice());
                    out.print("," + stocks.get(j).getStockQuantity());
                }
                out.println();
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

    private static void writeStockMarket(){
        try{
            File temp = new File(dirPath + "stockmarket.csv");
            if (!temp.exists())
                temp.createNewFile();
            PrintWriter out = new PrintWriter(temp);
            for (int i = 0; i < StockMarket.stockMarketList.size(); i++){
                Stock tempS = StockMarket.stockMarketList.get(i);
                out.print(tempS.getStockId() + "," + tempS.getStockName() + "," + tempS.getStockPrice());
                out.print("," + tempS.getStockBuyPrice() + "," + tempS.getStockQuantity());
                out.println();
            }
            out.close();
        }catch (IOException e){
            System.out.println("Error Occurred");
            System.out.println(e.getMessage());
        }
    }

}
