package javaHomework.hw1021;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeExecutor {
    public PrimeExecutor() {
        PrimeRunnable pr = new PrimeRunnable();
        PrimeCallable pc = new PrimeCallable();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(pr);
        Future<int[]> future = (Future<int[]>)service.submit(pc);
        try {
            System.out.println(future.get().length);
        } catch(InterruptedException e) {
            e.printStackTrace();
        } catch(ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    public static void main(String[] args) {
        new PrimeExecutor();
    }
}
