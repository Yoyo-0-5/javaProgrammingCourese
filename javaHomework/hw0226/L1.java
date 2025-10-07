package javaHomework.hw0226;

public class L1 {
    public static void l1()
    {
        double x = Math.random() * 10;
        while (x > 1)
        {
            System.out.println(x);
            x = Math.random() * 10;
        }
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        l1();
    }
}
