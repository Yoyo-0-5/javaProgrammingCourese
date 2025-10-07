package javaHomework.hw0325;

public class C9 {

    static int[][] time = new int[][] {
        {20, 30, 20, 0, 0, 0, 0, 0},
        {10, 20, 30, 40, 50, 60, 70, 80},
        {5, 15, 40, 50, 30, 10, 0, 0},
        {60, 60, 60, 60, 60, 60, 60, 60},
        {20, 20, 20, 20, 20, 20, 20, 20}
    };
    

    public static void c9()
    {
        for (int i = 0; i < time.length; i++) {
            int value = sum(time[i]);
            if( value > 100) {
                System.out.println("第" + (i + 1) + " 用戶總騎行時間是" + value + "該用戶有超過100分鐘獲得10卷");
            } else {
                System.out.println("第" + (i + 1) + " 用戶總騎行時間是" + value + "該用戶沒有獲得10卷");
            }
        }
    }

    private static int sum(int[] time) {
        int sum = 0;
        for (int i = 0; i < time.length; i++) {
            sum += time[i];
        }
        return sum;
    }



    public static void main(String[] args) {
        c9();
    }
}
