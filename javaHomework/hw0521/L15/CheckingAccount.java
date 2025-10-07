package javaHomework.hw0521.L15;


public class CheckingAccount extends Account {
    private int transactionLimit;
    private int transactionCount;

    public CheckingAccount(String accountNumber, String holderName, double balance, int transactionLimit) {
        super(accountNumber, holderName, balance);
        this.transactionLimit = transactionLimit;
        this.transactionCount = 0;
    }

    @Override
    public boolean deposit(double amount) {
        if (transactionCount < transactionLimit) {
            boolean result = super.deposit(amount);
            if (result) transactionCount++;
            return result;
        } else {
            System.out.println("已達本月交易限制，無法存款");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (transactionCount < transactionLimit) {
            boolean result = super.withdraw(amount);
            if (result) transactionCount++;
            return result;
        } else {
            System.out.println("已達本月交易限制，無法提款");
            return false;
        }
    }

    public int getRemainingTransactions() {
        return transactionLimit - transactionCount;
    }

    public void resetTransactions() {
        transactionCount = 0;
        System.out.println("本月交易次數重置成功");
    }
}
