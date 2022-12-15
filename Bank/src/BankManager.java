public class BankManager extends User{
    private String managerName;
    private int managerId;
    private double profit;

    public BankManager(String managerName, String managerPwd, int managerId){
        super("M", managerName,managerPwd,managerId);
        profit = 0;
    }

    public void checkCustomer(int customerId) {

    }

    public void getReport() {

    }

    public void chargeFee() {

    }

    public void paySavingInterest() {

    }

    public void lendLoan() {

    }

    public void AllowStockTrading() {

    }

    public String getName() {
        return managerName;
    }

    public void setFirstName(String firstName) {
        this.managerName = firstName;
    }

    public int getManagerId() {
        return this.managerId;
    }


}
