package javaHomework.hw0521.L15;

import java.util.ArrayList;
import java.util.List;


public class SavingAccount extends Account {
    private List<String> transactions;

    public SavingAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        transactions = new ArrayList<>();
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0) {
            boolean result = super.deposit(amount);
            if (result) {
                transactions.add("存款 " + amount + ", 餘額: " + getBalance());
            }
            return result;
        } else {
            System.out.println("存款金額需大於零");
            return false;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        double beforeBalance = getBalance();
        if (amount > 0 && beforeBalance >= amount) {
            boolean result = super.withdraw(amount);
            if (result) {
                transactions.add("提款 " + amount + ", 餘額: " + getBalance());
            }
            return result;
        } else {
            System.out.println("提款失敗，金額不足或輸入錯誤");
            return false;
        }
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void clearTransactions() {
        transactions.clear();
        System.out.println("本月交易紀錄清除成功");
    }
}
