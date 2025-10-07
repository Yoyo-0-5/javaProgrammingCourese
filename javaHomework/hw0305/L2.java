package javaHomework.hw0305;

import java.util.Scanner;


public class L2 {
    public static void l2()
    {
        
        System.out.println(conputeABCD());
    }

    private static double conputeABCD()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter four integers: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        scanner.close();
        double i = ((a + b + c + d) / 10.0 + b / c + (a + b + c + d) / 10.0) * (a + b + c + d) / 10.0;
        double j = ((a + b + c + d) / 10.0 + a / c + (a + b + c + d) / 10.0) * (a + b + c + d) / 10.0;
        double k = ((a + b + c + d) / 10.0 + (a + b) / c + (a + b + c + d) / 10.0) * (a + b + c + d) / 10.0;
        return i + j + k;
    }
    
    public static void main(String[] args) {
        l2();
    }
}
