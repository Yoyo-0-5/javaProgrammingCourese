package algorithm;

public class RandomQuickSort {
    public static long randomQuickSort(int[] array) {
        long startTime = System.nanoTime(); // Start time measurement
        randomQuickSortImp(array, 0, array.length - 1);
        long endTime = System.nanoTime(); // End time measurement
        return endTime - startTime;
    }

    private static void randomQuickSortImp(int[] array, int start, int end) {
        if (start < end) {
            int pi = randomPartition(array, start, end);
            randomQuickSortImp(array, start, pi - 1);
            randomQuickSortImp(array, pi + 1, end);
        }
    }

    private static int randomPartition(int[] array, int start, int end) {
        int randomIndex = (int) (Math.random() * (end - start + 1) + start);
        int temp = array[randomIndex];
        array[randomIndex] = array[end];
        array[end] = temp;
        return partition(array, start, end);
    }


    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j < end; j ++){
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        return i + 1;
    }
}
