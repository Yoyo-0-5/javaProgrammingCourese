package javaHomework.hw0325;

public class C8 {

    static int[][] plan = new int[][] {
        {1, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static void c8()
    {
        int cost = getCost(plan[0]);
        System.out.println("Plan 1 cost: " + cost);
        cost = getCost(plan[1]);
        System.out.println("Plan 2 cost: " + cost);
        cost = getCost(plan[2]);
        System.out.println("Plan 3 cost: " + cost);
        cost = getCost(plan[3]);
        System.out.println("Plan 4 cost: " + cost);
        cost = getCost(plan[4]);
        System.out.println("Plan 5 cost: " + cost);
    }

    private static int getCost(int[] plan) {
        int cost = 0;
        int planContinue = 0;
        for (int i = 0; i < plan.length; i++) {
            switch (plan[i])
            {
                case 0:
                    planContinue = 0;
                    break;
                case 1:
                    planContinue++;
                    if (planContinue > 6) {
                        cost = cost + 50;
                        planContinue = 0;
                    } else {
                        cost = cost + 100;
                    }
                    break;
                case 2:
                    planContinue++;
                    if (planContinue > 6) {
                        cost = cost + 75;
                        planContinue = 0;
                    } else {
                        cost = cost + 150;
                    }
                    break;
                default:
                    System.out.println("Error: " + plan[i]);
                    break;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        c8();
    }
}
