package javaHomework.hw0226;

import java.util.Scanner;

public class L5 {
    public static void l5()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two number: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        while (n % m != 0)
        {
            int temp = n % m;
            n = m;
            m = temp;
        }
        System.out.println(m);
    }
    
    public static void main(String[] args) {
        l5();
    }
}
