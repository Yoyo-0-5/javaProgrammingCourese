package javaHomework.hw0225;

import java.util.Scanner;

public class L4 {
    public static void l4()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入 姓名 身高(公分或公尺) 體重(公斤) : ");
        String name = scanner.next();
        double height = scanner.nextDouble();
        double weight = scanner.nextDouble();
        scanner.close();
        if (height > 3)
            height /= 100;
        double bmi = weight / Math.pow(height, 2);
        System.out.println(name + " 的身高比例係數為 " + bmi);
    }
    
    public static void main(String[] args) {
        l4();
    }
}
