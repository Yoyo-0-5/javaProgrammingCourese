package javaHomework.hw1021;

import java.util.ArrayList;

public class Prime {

    private int limit;

    public Prime(int limit) {
        this.limit = limit;
    }

    public int[] prime() {
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                prime.add(i);
            }
        }
        return listToArray(prime);
    }


    private boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int[] listToArray(ArrayList<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }
        return result;
    }

}