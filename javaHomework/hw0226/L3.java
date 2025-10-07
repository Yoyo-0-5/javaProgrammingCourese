package javaHomework.hw0226;

import java.util.Scanner;

public class L3 {
    public static void l3()
    {
        Scanner scannner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scannner.nextInt();
        scannner.close();

        nonPrime: // label for the outer loop
        for (int i = 2; i <= n; i++)
        {
            for (int j = 2; j <= Math.sqrt(i); j++)
            {
                if (i % j == 0)
                {
                    continue nonPrime;
                }
            }
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        l3();
    }
}
