package algorithm;

public class MergeSort {

    public static long mergeSort(int[] array) {
        long startTime = System.nanoTime(); // Start time measurement
        mergeSortImp(array, 0, array.length - 1);
        long endTime = System.nanoTime(); // End time measurement
        return endTime - startTime;
    }

    public static void mergeSortImp(int[] array, int start, int end) {
        
        if (start < end) {
            int mid = (end + start) / 2;
            mergeSortImp(array, start, mid);
            mergeSortImp(array, mid + 1, end);
            int[] arrayTemp = new int[end - start + 1];
            int first = start;
            int second = mid + 1;
            int index = 0;

            while (first <= mid && second <= end) {
                if (array[first] <= array[second]) {
                    arrayTemp[index++] = array[first++];
                } else {
                    arrayTemp[index++] = array[second++];
                }
            }

            while (first <= mid) {
                arrayTemp[index++] = array[first++];
            }

            while (second <= end) {
                arrayTemp[index++] = array[second++];
            }

            for (int i = 0; i < arrayTemp.length; i++) {
                array[start + i] = arrayTemp[i];
            }
            
        }
    }

}
