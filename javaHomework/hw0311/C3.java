package javaHomework.hw0311;

import java.util.Scanner;

public class C3 {

    static String account = "admin";
    static String password = "CHANGEME";  
    
    public static void c3()
    {
        try (Scanner scanner = new Scanner(System.in)) {
            int i;
            for (i = 0; i < 3; i++) {
                System.out.print("Please enter your account: ");
                String scAccount = scanner.nextLine();
                System.out.print("Please enter your password: ");
                String scPassword = scanner.nextLine();

                if (check(scAccount, scPassword)) {
                    System.out.println("Login successfully!");
                    break;
                } else {
                    System.out.println("Login failed!");
                }
            }
            
            if (i == 3) {
                System.out.println("You have tried 3 times, please try again later!");
            }
        }
    }
    
    private static Boolean check(String scAccount, String scPassword) {
        return scAccount.equals(account) && scPassword.equals(password);
    }

    public static void main(String[] args) {
        c3();
    }
}
