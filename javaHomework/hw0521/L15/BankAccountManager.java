package javaHomework.hw0521.L15;

public class BankAccountManager {
    public static void main(String[] args) {
        
        CheckingAccount c1 = new CheckingAccount("A123456", "王小明", 5000, 3);
        
        SavingAccount s1 = new SavingAccount("B56789", "李大華", 200000);

        
        c1.deposit(10000);
        c1.withdraw(3000);
        c1.deposit(8000);
        c1.withdraw(1000);
        System.out.println("剩餘交易次數: " + c1.getRemainingTransactions());
        c1.resetTransactions();
        System.out.println("重置後剩餘交易次數: " + c1.getRemainingTransactions());

        System.out.println("----------------------");

        
        s1.deposit(50000);
        s1.withdraw(100000);
        System.out.println("目前餘額: " + s1.getBalance());
        System.out.println("本月交易紀錄:");
        for (String record : s1.getTransactions()) {
            System.out.println(record);
        }
        s1.clearTransactions();
        System.out.println("清除後交易紀錄: " + s1.getTransactions());
    }
}
