package javaHomework.hw0422;

import java.util.Scanner;

public class C13 
{
    int n = 0;
    private int[] like = new int[100];
    private int[] comment = new int[100];
    private int[] fever = new int[100];
    private int highestFeverIndex = 0;

    public C13() 
    {
        scannerData();
        printData();
        getFever();
        printFever();
    }

    private void scannerData() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入貼文數量: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            System.out.println("請輸入第" + (i + 1) + "筆貼文的");
            System.out.print(" 1. 點讚數: ");
            like[i] = sc.nextInt();
            System.out.print(" 2. 留言數: ");
            comment[i] = sc.nextInt();
        }
        sc.close();
    }

    private void printData() 
    {
        System.out.println("貼文的點讚數和留言數為: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.println("第" + (i + 1) + "筆貼文的點讚數: " + like[i] + ", 留言數: " + comment[i]);
        }
    }

    private void getFever()
    {
        for (int i = 0; i < n; i++) 
        {
            fever[i] = like[i] + comment[i];
            if (fever[i] > fever[highestFeverIndex]) 
            {
                highestFeverIndex = i;
            }
        }
    }

    private void printFever() 
    {
        System.out.println("貼文的熱度為: ");
        for (int i = 0; i < n; i++) 
        {
            System.out.println("第" + (i + 1) + "筆貼文的熱度: " + fever[i]);
        }
        System.out.println("最高熱度為貼文: " + (highestFeverIndex + 1));
    }

    public static void main(String[] args) 
    {
        new C13();
    }
}
