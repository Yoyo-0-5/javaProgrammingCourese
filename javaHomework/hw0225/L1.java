package javaHomework.hw0225;
import java.util.Scanner;

public class L1 {
    public static void l1()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入三個怎數: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        int max = a;
        int min = a;
        if (b > max) {
            max = b;
        }
        else if (b < min) {
            min = b;
        }
        if (c > max) {
            max = c;
        }
        else if (c < min) {
            min = c;
        }
        System.out.println("最大值: " + max);
        System.out.println("最小值: " + min);
    }
    
    public static void main(String[] args) {
        l1();
    }
}
