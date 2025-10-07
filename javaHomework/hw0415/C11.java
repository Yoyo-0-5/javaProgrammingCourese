package javaHomework.hw0415;
import java.util.Scanner;

public class C11 
{
    public C11()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入今天的總座位數: ");
        int totalSeats = scanner.nextInt();
        System.out.print("請輸入今天訂位組次的數量: ");
        int numRequests = scanner.nextInt();

        for (int i = 1; i <= numRequests; i++)
        {
            System.out.print("請輸入第 " + i + " 組訂位的座位數: ");
            int requestedSeats = scanner.nextInt();

            if (requestedSeats > totalSeats)
            {
                System.out.println("訂位失敗，超過總座位數");
                continue;
            }

            System.out.println("訂位成功");
            totalSeats -= requestedSeats;
        }

        scanner.close();

        System.out.println("今天剩餘的座位數: " + totalSeats);
    }


    public static void main(String[] args)
    {
        new C11();
    }
}
