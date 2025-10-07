package algorithm;

public class HeapSort {
    public static long heapSort(int[] array)
    {
        long startTime = System.nanoTime(); // Start time measurement
        int length = array.length;
        for (int i = (int)Math.ceil(array.length / 2) - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            length--;
            heapify(array, length, 0);
        }
        long endTime = System.nanoTime(); // End time measurement
        return endTime - startTime;
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    private static void heapify(int[] array, int length, int index)
    {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }
}
