package javaHomework.hw0318;

public class C5 {
    public static void c5()
    {
        Scores scores = new Scores(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100});
        System.out.println("Average: " + scores.getAverage());
        System.out.println("Max: " + scores.getMax());
        System.out.println("Min: " + scores.getMin());
    }
    
    private static class Scores {
        private int[] scores;
        private int sum;
        private int average;
        private int max;
        private int min;
        
        public Scores(int[] scores) {
            this.scores = scores;
            this.sum = getSum();
        }
        
        private int getSum() {
            for (int i = 0; i < scores.length; i++) {
                average += scores[i];
            }
            return average;
        }

        public int getAverage() {
            return sum / scores.length;
        }

        public int getMax() {
            max = scores[0];
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] > max) {
                    max = scores[i];
                }
            }
            return max;
        }

        public int getMin() {
            min = scores[0];
            for (int i = 1; i < scores.length; i++) {
                if (scores[i] < min) {
                    min = scores[i];
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        c5();
    }
}
