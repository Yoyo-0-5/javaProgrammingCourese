package algorithm;

public class BubbleSort {
    public static long bubbleSort(int[] array) {
        long startTime = System.nanoTime(); // Start time measurement
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        long endTime = System.nanoTime(); // End time measurement
        return endTime - startTime;
    }
}
