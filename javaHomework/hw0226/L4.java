package javaHomework.hw0226;

import java.util.Scanner;

public class L4 {
    public static void l4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.close();
        double sum = 0;
        for (int i = 0; i <= n; i++)
        {
            sum = sum + ((i % 2 == 0 ? 1 : -1) / (2.0 * i + 1));
        }
        System.out.println(sum * 4);
    }
    
    public static void main(String[] args) {
        l4();
    }
}
