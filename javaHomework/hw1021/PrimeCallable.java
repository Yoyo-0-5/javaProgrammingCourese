package javaHomework.hw1021;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PrimeCallable implements Callable<int[]> {

    @Override
    public int[] call() throws Exception {
        Prime prime = new Prime(200000);
        int[] result;
        Long start = System.currentTimeMillis();
        result = prime.prime();
        System.out.println(result.length);
        Long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
        return result;
    }
    
    
    public static void main(String[] args) {
        new Thread(new FutureTask<int[]>(new PrimeCallable())).start();
    }
}
