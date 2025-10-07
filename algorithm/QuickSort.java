package algorithm;
public class QuickSort {
    public static long quickSort(int[] array) {
        long startTime = System.nanoTime(); // Start time measurement
        quickSortImp(array, 0, array.length - 1);
        long endTime = System.nanoTime(); // End time measurement
        return endTime - startTime;
    }

    private static void quickSortImp(int[] array, int start, int end) {
        if (start < end) {
            int pi = partition(array, start, end);
            quickSortImp(array, start, pi - 1);
            quickSortImp(array, pi + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
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
