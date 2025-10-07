package javaHomework.hw0225;
import java.util.Scanner;

public class L3 {
    public static void l3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入 bmi 值 : ");
        double bmi = scanner.nextDouble();
        scanner.close();
        if (bmi < 18.5)
            System.out.println("過輕");
        else if (bmi < 24)
            System.out.println("正常");
        else if (bmi < 27)
            System.out.println("過重");
        else
            System.out.println("輕度肥胖");
    }
    
    public static void main(String[] args) {
        l3();
    }
}
