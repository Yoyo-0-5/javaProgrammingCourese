package javaHomework.hw1014;

import java.util.Scanner;

public class Example3 {

    public Example3() {
        int number = getNumber();
        System.out.println("The number is: " + number);
    }

    public int getNumber() {
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        try {
            input = scanner.nextInt();
            if(input > 3 || input < 0) {
                throw new CustomException(input);
            }
        } catch (CustomException e) {
            System.out.println("例外說明: " + e.getMessage());
            input = getNumber();
        } finally {
            scanner.close();
        }
        
        return input;
    }

    public static void main(String[] args) {
        new Example3();
    }

}
