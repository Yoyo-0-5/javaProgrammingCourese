package javaHomework.hw0311;

public class C2 {
    public static void c2()
    {
        Staff staff[] = new Staff[]{
            new Staff(new int[]{1, 2, 3, 4, 5, 6, 7}),
            new Staff(new int[]{2, 3, 4, 5, 6, 7, 8}),
            new Staff(new int[]{3, 4, 5, 6, 7, 8, 9}),
            new Staff(new int[]{4, 5, 6, 7, 8, 9, 10}),
            new Staff(new int[]{5, 6, 7, 8, 9, 10, 11})
        };
        
        for (int i = 1; i <= staff.length; i++) {
            System.out.println("Weekly salary of staff" + i + ": " + staff[i - 1].getWeeklySalary());
        }
        
    }
    
    private static class Staff {
        private int[] daily = new int[7];
        private int weekly;

        public Staff(int[] daily) {
            this.daily = daily;
            this.weekly = getWeekly();
        }

        private int getWeekly() {
            int sum = 0;
            for (int i = 0; i < daily.length; i++) {
                sum += daily[i];
            }
            return sum;
        }

        public int getWeeklySalary() {
            return weekly;
        }
    }

    public static void main(String[] args) {
        c2();
    }
}
