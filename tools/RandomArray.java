package tools;

import java.util.Random;

public class RandomArray {
    public static int[] generateRandomArray(int size) { // Method in RandomArrayGenerator
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000000); // 生成範圍在 0 到 999999 的隨機數
        }
        return arr;
    }
}
