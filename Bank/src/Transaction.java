public class Transaction {
    private Account senderAccount;
    private Account receiverAccount;
    private double sendAmount;
    private CurrencyType sendType;
    private CurrencyType recvType;

    public Transaction(Account senderAccount, Account receiverAccount, double sendAmount, CurrencyType sendType, CurrencyType recvType){
         senderAccount.withdraw(sendType,sendAmount);
         double amount = Exchange.exchangeCurrency(sendType,recvType,sendAmount);
         receiverAccount.deposit(recvType, amount);
         this.senderAccount = senderAccount;
         this.receiverAccount = receiverAccount;
         this.sendAmount = sendAmount;
         this.sendType = sendType;
         this.recvType = recvType;
         Report.addTransaction(this);
    }

    @Override //need to specify account toString
    public String toString(){
        return senderAccount + " sends " + sendAmount + sendType + " to " + receiverAccount;
    }
}
