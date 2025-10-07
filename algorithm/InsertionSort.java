package algorithm;

public class InsertionSort {

    public static long insertionSort(int[] array) {
        long startTime = System.nanoTime(); // Start time measurement
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i - 1; j >= 0 && array[j] > key; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
        long endTime = System.nanoTime(); // End time measurement
        return endTime - startTime;
    }
}
