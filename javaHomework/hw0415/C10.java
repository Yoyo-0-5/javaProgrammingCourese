package javaHomework.hw0415;
import java.util.Scanner;

public class C10
{
    public C10()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入課程章節總數: ");
        int totalChapters = scanner.nextInt();

        System.out.print("請輸入學生人數: ");
        int numberOfStudents = scanner.nextInt();

        for (int i = 1; i <= numberOfStudents; i++)
        {
            boolean[] completedChapters = new boolean[totalChapters + 1];
            System.out.print("請輸入第 " + i + "位學生已完成的章節數 (-1 結束): ");
            while (true)
            {
                int chapter = scanner.nextInt();
                
                if (chapter == -1)
                {
                    break;
                }

                if (!RegisteredChapters(completedChapters, chapter))
                {
                    System.out.println("你章節輸入錯誤，請重新輸入: ");
                }
            }

            if (!finishAllChapters(completedChapters))
            {
                System.out.println("學生 " + i + " 未完成所有課程");
                continue;
            }
            System.out.println("學生 " + i + " 已完成所有課程");
        }
        scanner.close();
    }


    private boolean RegisteredChapters(boolean[] completedChapters, int chapter)
    {
        if (chapter < 1 || chapter >= completedChapters.length)
        {
            return false;
        }
        completedChapters[chapter] = true;
        return true;
    }


    private boolean finishAllChapters(boolean[] completedChapters)
    {
        for (int i = 1; i < completedChapters.length; i++)
        {
            if (!completedChapters[i])
            {
                return false;
            }
        }
        return true;
    }
    

    public static void main(String[] args)
    {
        new C10();
    }
}
