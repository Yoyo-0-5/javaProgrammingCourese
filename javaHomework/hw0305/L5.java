package javaHomework.hw0305;

public class L5 {
    public static void l5()
    {
        int i = 1, j = 2, k = 3;
        int a1 = method(i, j);
        System.out.println("The return value: " + a1);

        i = 5; 
        j = 6;
        int a2 = method(i, j, k);
        System.out.println("The return value: " + a2);

        double x = 0.8, y = 0.3;
        double a3 = method(x, y);
        System.out.println("The return value: " + a3);
    }

    private static int method (int i, int j)
    {
        return i + j;
    }

    private static int method (int i, int j, int k)
    {
        return i + j;
    }

    private static double method (double i, double j)
    {
        return i + j;
    }
    
    public static void main(String[] args) {
        l5();
    }
}
