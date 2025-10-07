package javaHomework.hw0422;
import java.util.Scanner;

public class C15 {
    public C15()
    {
        Scanner scanner = new Scanner(System.in);

        // 輸入遊客人數
        System.out.print("請輸入遊客人數: ");
        int visitorCount = scanner.nextInt();

        // 建立陣列來存放評分
        int[] scores = new int[visitorCount];

        // 建立陣列來統計每個評分的人數 (1到5分)
        int[] scoreCounts = new int[5];

        // 輸入每位遊客的評分
        for (int i = 0; i < visitorCount; i++) {
            int score;
            do {
                System.out.print("請輸入第 " + (i + 1) + " 位遊客的評分 (1-5): ");
                score = scanner.nextInt();
            } while (score < 1 || score > 5); // 確保評分在1到5之間

            scores[i] = score;
            scoreCounts[score - 1]++; // 統計評分人數
        }

        // 計算平均分數
        int totalScore = 0;
        for (int score : scores) {
            totalScore += score;
        }
        double averageScore = (double) totalScore / visitorCount;

        // 輸出結果
        System.out.println("景點滿意度調查結果:");
        System.out.printf("平均分數: %.2f\n", averageScore);
        for (int i = 0; i < scoreCounts.length; i++) {
            System.out.println((i + 1) + " 分: " + scoreCounts[i] + " 人");
        }

        scanner.close();
    }
    public static void main(String[] args)
    {
        new C15();
    }
}
