package javaHomework.hw0311;

public class C1 {
    public static void c1()
    {
        int[] scores = { 100, 90, 80, 70, 60, 50, 40, 30, 20, 10 };
        double average = getAverage(scores, 60);
        System.out.println("Average score: " + average);
    }

    private static double getAverage(int[] scores, int range)
    {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < scores.length; i++)
        {
            if (scores[i] < range)
            {
                continue;
            }
            sum += scores[i];
            count++;
        }
        return sum / count;
    }
    
    public static void main(String[] args) {
        c1();
    }
}
