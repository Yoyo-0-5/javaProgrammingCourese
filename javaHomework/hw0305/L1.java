package javaHomework.hw0305;

public class L1 {
    public static void l1()
    {
        System.out.println("printStar function: ");
        printStar(5);
        System.out.println("getStar function: ");
        System.out.println(getSter(5));
        
    }

    private static void printStar (int level)
    {
        int i, j;
        for (i = 1; i <= level; i++)
        {
            for (j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static String getSter(int level)
    {
        String str = "";
        for (int i = 1; i <= level; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                str += "*";
            }
            str += "\n";
        }
        return str;
    }
    
    public static void main(String[] args) {
        l1();
    }
}
