package algorithm;

import tools.RandomArray;

public class SortingTest {
    public static void sortingTest(int arraySize, int testTimes) {
        System.out.println("Array size: " + arraySize + ", Test times: " + testTimes);
        testSortingAlgorithm("Bubble Sort", arraySize, testTimes, BubbleSort::bubbleSort);
        testSortingAlgorithm("Insertion Sort", arraySize, testTimes, InsertionSort::insertionSort);
        testSortingAlgorithm("Quick Sort", arraySize, testTimes, QuickSort::quickSort);
        testSortingAlgorithm("Random Quick Sort", arraySize, testTimes, RandomQuickSort::randomQuickSort);
        testSortingAlgorithm("Merge Sort", arraySize, testTimes, MergeSort::mergeSort);
        testSortingAlgorithm("Heap Sort", arraySize, testTimes, HeapSort::heapSort);
    }

    private static void testSortingAlgorithm(String name, int size, int times, SortingFunction sorter) {
        long totalTime = 0;
        for (int i = 0; i < times; i++) {
            int[] arr = RandomArray.generateRandomArray(size);
            totalTime += sorter.sort(arr);
        }
        System.out.println(name + ": " + totalTime / times / 1000 + " us");
    }

    @FunctionalInterface
    interface SortingFunction {
        long sort(int[] arr);
    }
}
