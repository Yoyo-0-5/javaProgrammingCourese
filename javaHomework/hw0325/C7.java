package javaHomework.hw0325;

public class C7 {

    static int[] client = new int[] {700, 900, 1200, 1500, 1800, 2100, 2400};

    public static void c7()
    {
        for (int i = 1; i <= 7; i++) {
            System.out.println("星期" + transChenese(i) + "的日活耀用戶數是 " + client[i-1]);
        }
        System.out.println(getAverage(client));
    }



    private static String transChenese(int i) {
        switch (i) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "日";
            default:
                return null;
        }
    }

    private static double getAverage(int[] client) {
        double sum = 0;
        for (int i = 0; i < client.length; i++) {
            sum += client[i];
        }
        return sum / client.length;
    }
    

    public static void main(String[] args) {
        c7();
    }
}
