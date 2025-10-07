package javaHomework.hw0305;

public class L4 {
    public static void l4()
    {
        int i = 10;
        double j = 10.5;
        System.out.println("square of " + i + " is " + square(i));
        System.out.println("square of " + j + " is " + square(j));
    }

    private static int square (int a)
    {
        return a * a;
    }

    private static double square (double a)
    {
        return a * a;
    }
    
    public static void main(String[] args) {
        l4();
    }
}
