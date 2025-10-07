package javaHomework.hw0422;
import java.util.Scanner;

public class C14 {
    public C14()
    {
        Scanner scanner = new Scanner(System.in);

        // 輸入學生人數
        System.out.print("請輸入學生人數: ");
        int studentCount = scanner.nextInt();

        // 建立陣列來存放學生成績
        int[] scores = new int[studentCount];

        // 輸入每位學生的成績
        for (int i = 0; i < studentCount; i++) {
            System.out.print("請輸入第 " + (i + 1) + " 位學生的成績: ");
            scores[i] = scanner.nextInt();
        }

        // 判斷成績等級並輸出評語
        for (int i = 0; i < studentCount; i++) {
            String grade;
            if (scores[i] >= 90) {
                grade = "優秀";
            } else if (scores[i] >= 80) {
                grade = "良好";
            } else if (scores[i] >= 70) {
                grade = "中等";
            } else if (scores[i] >= 60) {
                grade = "及格";
            } else {
                grade = "不及格";
            }
            System.out.println("第 " + (i + 1) + " 位學生的成績是: " + scores[i] + "，評語: " + grade);
        }

        scanner.close();
    }
    public static void main(String[] args)
    {
        new C14();
    }
}
