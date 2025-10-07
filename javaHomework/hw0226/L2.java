package javaHomework.hw0226;

public class L2 {
    public static void l2()
    {
        int x = 2;
        do{
            System.out.println(x);
            x = (int)Math.pow(x, 2);
        } while (x < 100);
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        l2();
    }
}
